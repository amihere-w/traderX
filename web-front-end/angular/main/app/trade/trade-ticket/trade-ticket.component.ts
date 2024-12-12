import { Component, Input, Output, EventEmitter, OnInit, AfterViewInit, ElementRef, ViewChild, signal } from '@angular/core';
import { TradeTicket } from 'main/app/model/trade.model';
import { Stock } from 'main/app/model/symbol.model';
import { Account } from 'main/app/model/account.model';
import { TypeaheadMatch } from 'ngx-bootstrap/typeahead';
import { v4 as uuidv4 } from 'uuid';
import { BsModalRef } from 'ngx-bootstrap/modal';
import * as jsonData from "../../../assets/morphir-ir.json"

@Component({
  selector: 'app-trade-ticket',
  templateUrl: './trade-ticket.component.html',
  styleUrls: ['./trade-ticket.component.scss']
})


export class TradeTicketComponent implements OnInit, AfterViewInit {

  @Input() stocks: Stock[];
  @Input() account: Account | undefined;

  @Output() create = new EventEmitter<TradeTicket>();
  @Output() cancel = new EventEmitter();

  selectedCompany?: string = undefined;
  ticket: TradeTicket;
  filteredStocks: Stock[] = [];
  modalRef?: BsModalRef;
  
  // morphir-insight component inclution stuff 
  @ViewChild('morphirInsight', {static: false}) morphirInsight: ElementRef<any>;
  
  distribution: Object | null = null;
  tradeOrder: any = {}
  tradeOrderOldValue: any = {}
  dataSignal = signal({id: "",state: ["New"],security: "",accountId: 0,quantity: 0,side: ["BUY"],action: ["NEW_TRADE"],filled: 0})
  morphirInsightElement: any

  ngOnInit() {
    this.ticket = {
      id: "",
      action: "NEWTRADE",
      state: "New",
      quantity: 0,
      accountId: this.account?.id || 0,
      side: "Buy",
      security: ""
    };

    this.tradeOrder = {id: uuidv4(),state: ["New"],security: "",accountId: 0,quantity: 0,side: ["BUY"],action: ["NEW_TRADE"],filled: 0}
    this.tradeOrderOldValue = {id: uuidv4(),state: ["New"],security: "",accountId: 0,quantity: 0,side: ["BUY"],action: ["NEW_TRADE"],filled: 0}

    this.filteredStocks = this.stocks;
    this.distribution = JSON.stringify(jsonData)
  }
  

  ngAfterViewInit(): void {
    console.log("morphir stuff", this.tradeOrder)
    this.morphirInsight.nativeElement.init(this.distribution)
  }

  onSelect(e: TypeaheadMatch): void {
    console.log('Selected value: ', e.value);
    this.ticket.security = e.item.ticker;
  }

  onBlur(): void {
    if (this.selectedCompany) return;
    this.ticket.security = '';
  }

  onCreate() {
    if (!this.ticket.security || !this.ticket.quantity) {
      console.warn('Either security is not selected or quanity is not set!');
      return;
    }
    console.log('create tradeTicket', this.ticket);
    this.create.emit(this.ticket);
  }

  onCancel() {
    this.cancel.emit();
  }


  validateTrade(){
    this.tradeOrder.side = [this.ticket.side.toUpperCase()]
    this.tradeOrder.state = [this.ticket.state]
    this.tradeOrder.quantity = this.ticket.quantity == null ? 0 : this.ticket.quantity
    console.log("New Trade Order", this.tradeOrder)
    this.morphirInsight.nativeElement.attributeChangedCallback('arguments', JSON.stringify([this.tradeOrderOldValue]), JSON.stringify([this.tradeOrder]))
  }

}
