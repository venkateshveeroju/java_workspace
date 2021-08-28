import { Component, OnInit } from '@angular/core';
import { EmailValidator } from '@angular/forms';

import { ContactService } from '../_services/contact.service';

@Component({
  selector: 'app-contact',
  templateUrl: './contact.component.html',
  styleUrls: ['./contact.component.scss']
})
export class ContactComponent implements OnInit {
  fname: string;
  fmessage: string;
  fcountry: string;
  lname: string;
  femail: string;
  fsubject: string;
  name: '';
  country: '';
  message: '';
  email: '';
  id: '';
  subject: '';


  constructor(private contactService: ContactService) { }

  ngOnInit(): void {


  }
  onSubmit($event) {

    const data = {
      id: 1,
      name: this.fname + ' ' + this.lname,
      country: this.fcountry,
      message: this.fmessage,
      email: this.femail,
      subject: this.fsubject,
    }



    this.contactService.contact(data)
      .subscribe(
        response => {
          console.log(response);
          //alert("Saved sucessfully")
        },
        error => {
          console.log(error);
          // alert("Saved sucessfully")
        });
  }
  ngModel(ngModel: any) {
    throw new Error('Method not implemented.');
  }

  ValidateEmail(email) {
    var emailformat = /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(String(email).toLowerCase());
    if (email.match(emailformat)) {
      alert("Nice Email!")
      return true;
    };
    alert("That's not an email?!")
    return (false);
  };
}

function emailref(emailref: any) {
  throw new Error('Function not implemented.');
}
