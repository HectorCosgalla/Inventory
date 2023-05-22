import { Component, OnInit } from '@angular/core';
import { Usertable } from '../../model/usertable';
import { UserService } from '../user-service.service';

@Component({
  selector: 'app-user-list',
  templateUrl: './user-list.component.html',
  styleUrls: ['./user-list.component.css']
})
export class UserListComponent implements OnInit {
  users: Usertable[];

  constructor(private userService: UserService) {
  }
  ngOnInit() {
    this.userService.findAll().subscribe(data => 
      this.users = data)
  }

}
