import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanDeactivate, RouterStateSnapshot, UrlTree } from '@angular/router';
import { Observable } from 'rxjs';
import { ProductFormComponent } from './product-form/product-form.component';

@Injectable({
  providedIn: 'root'
})
export class FormStatusGuard implements CanDeactivate<unknown> {
  canDeactivate(
    component: ProductFormComponent,
    currentRoute: ActivatedRouteSnapshot,
    currentState: RouterStateSnapshot,
    nextState?: RouterStateSnapshot): Observable<boolean | UrlTree> | Promise<boolean | UrlTree> | boolean | UrlTree {
    console.log("FormStatusGuard::deActivate");
    if (component.cancelled) {
      return true;
    } else {
      return false;
    }
  }

}
