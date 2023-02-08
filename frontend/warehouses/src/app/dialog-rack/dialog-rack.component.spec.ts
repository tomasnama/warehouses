import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DialogRackComponent } from './dialog-rack.component';

describe('DialogRackComponent', () => {
  let component: DialogRackComponent;
  let fixture: ComponentFixture<DialogRackComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DialogRackComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(DialogRackComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
