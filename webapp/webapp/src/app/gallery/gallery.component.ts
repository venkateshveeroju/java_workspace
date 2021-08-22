import { Component, OnInit } from '@angular/core';
import { NgxGalleryOptions, NgxGalleryImage, NgxGalleryAnimation } from 'ngx-gallery-9';
import 'hammerjs';

@Component({
  selector: 'app-gallery',
  templateUrl: './gallery.component.html',
  styleUrls: ['./gallery.component.scss']
})

export class GalleryComponent implements OnInit {

  constructor() { }
  galleryOptions: NgxGalleryOptions[];
  galleryImages: NgxGalleryImage[];

  ngOnInit(): void {
    this.galleryOptions = [
      {
        width: '1200px',
        height: '600px',
        thumbnailsColumns: 3,
        thumbnailsRows: 2,
        image: false
      },
      // max-width 800
      {
        breakpoint: 800,
        width: '100%',
        height: '400px'
      },
      // max-width 400
      {
        breakpoint: 400,
        width: '100%',
        preview: false
      }
    ];

    this.galleryImages = [
      {
        small: 'assets/images/p1.jpg',
        medium: 'assets/images/p1.jpg',
        big: 'assets/images/p1.jpg'
      },
      {
        small: 'assets/images/p2.jpg',
        medium: 'assets/images/p2.jpg',
        big: 'assets/images/p2.jpg'
      },
      {
        small: 'assets/images/p3.jpg',
        medium: 'assets/images/p3.jpg',
        big: 'assets/images/p3.jpg'
      },
      {
        small: 'assets/images/b1.jpg',
        medium: 'assets/images/b1.jpg',
        big: 'assets/images/b1.jpg'
      },
      {
        small: 'assets/images/b2.jpg',
        medium: 'assets/images/b2.jpg',
        big: 'assets/images/b2.jpg'
      },
      {
        small: 'assets/images/b3.jpg',
        medium: 'assets/images/b3.jpg',
        big: 'assets/images/b3.jpg'
      }
    ];
  }
}


