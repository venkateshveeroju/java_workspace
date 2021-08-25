import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/_services';
import { DomSanitizer } from '@angular/platform-browser';
import { base64StringToBlob } from 'blob-util';
@Component({
  selector: 'app-lab-management',
  templateUrl: './lab-management.component.html',
  styleUrls: ['./lab-management.component.scss']
})
export class LabManagementComponent implements OnInit {

  content: any;
  name = 'Test display image';
  thumbnail: any;
  sanitizer: any;
  url: any;
  base64Image: any;
  imagePath: any;
  image: any;
   list: any[] = [];
  constructor(private userService: UserService, private _sanitizer: DomSanitizer) { }

  ngOnInit() {

    this.userService.getPublicContent().subscribe(
      response => {
        
        this.content=response;
        
        response.forEach(element => {
          
          let objectURL = 'data:image/png;base64,' + element['image'];
         
          this.list.push(this._sanitizer.bypassSecurityTrustUrl(objectURL));
          this.content['image']=this._sanitizer.bypassSecurityTrustUrl(objectURL);
         
          console.log(this.content['image']);
      });
      
      // let objectURL = 'data:image/png;base64,' + response[0]['image'];
      //   this.image = this._sanitizer.bypassSecurityTrustUrl(objectURL);

      },
      err => {
        this.content = JSON.parse(err.error).message;
      }
    );
  }

}
function parseObject(arg0: any) {
  throw new Error('Function not implemented.');
}

