import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TodosFooterComponent } from './todos-footer.component';

describe('TodosFooterComponent', () => {
  let component: TodosFooterComponent;
  let fixture: ComponentFixture<TodosFooterComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TodosFooterComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(TodosFooterComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
