import { Component } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  templateUrl: './user-login.component.html',
  styleUrls: ['./user-login.component.scss']
})
export class UserLoginComponent {
  formLogin = new FormGroup({
    username: new FormControl(),
    password: new FormControl()
  })
  onSubmit() {
    // TODO: Use EventEmitter with form value
    console.warn(this.formLogin.value);
  }
}

