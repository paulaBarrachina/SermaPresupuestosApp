import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ClienteListPagedComponent } from './cliente-list-paged.component';

describe('ClienteListPagedComponent', () => {
  let component: ClienteListPagedComponent;
  let fixture: ComponentFixture<ClienteListPagedComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ClienteListPagedComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ClienteListPagedComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
