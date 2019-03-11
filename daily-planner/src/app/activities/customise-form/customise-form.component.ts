import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';

@Component({
  selector: 'app-customise-form',
  templateUrl: './customise-form.component.html',
  styleUrls: ['./customise-form.component.css']
})
export class CustomiseFormComponent implements OnInit {
  modelForm: FormGroup;

  constructor(private fb: FormBuilder) {
    this.modelForm = this.fb.group({
      name: ''
    });
  }

  ngOnInit() {
  }

}