import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-footer',
  templateUrl: './footer.component.html',
  styleUrls: ['./footer.component.scss']
})
export class FooterComponent implements OnInit {
  private linkedinUrl: string = 'https://www.linkedin.com/in/';
  private facebookUrl:string = 'https://www.facebook.com/';
  private twitterUrl:string = 'https://twitter.com/';
  private googleUrl:string = 'https://plus.google.com/';
  constructor() { }

  ngOnInit() {
  }

}
