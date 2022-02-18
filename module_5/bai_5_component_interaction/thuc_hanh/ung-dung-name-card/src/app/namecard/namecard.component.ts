import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-namecard',
  templateUrl: './namecard.component.html',
  styleUrls: ['./namecard.component.scss']
})
export class NamecardComponent implements OnInit {


  @Input() cardName: string;
  @Input() email: string;
  @Input() phone: string;

  constructor() { }

  ngOnInit(): void {
  }

}
