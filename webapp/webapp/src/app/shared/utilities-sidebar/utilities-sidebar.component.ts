import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-utilities-sidebar',
  templateUrl: './utilities-sidebar.component.html',
  styleUrls: ['./utilities-sidebar.component.scss']
})
export class UtilitiesSidebarComponent implements OnInit {
  
  public imagesUrl: string[];
  constructor() { }

  ngOnInit() {
    this.imagesUrl = ['https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/5.jpg', 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/9.jpg', 'https://sanjayv.github.io/ng-image-slider/contents/assets/img/slider/4.jpg'];
  }
  name = 'Angular';
 
}
