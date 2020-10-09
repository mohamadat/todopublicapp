import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TodoDocComponent } from './todo-doc.component';

describe('TodoDocComponent', () => {
  let component: TodoDocComponent;
  let fixture: ComponentFixture<TodoDocComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TodoDocComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TodoDocComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
