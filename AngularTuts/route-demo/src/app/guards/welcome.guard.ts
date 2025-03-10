import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, CanActivate, CanActivateFn, GuardResult, MaybeAsync, RouterStateSnapshot } from '@angular/router';
import { RoleService } from '../services/role.service';

@Injectable({
  providedIn: 'root'
})

export class WelcomeGuard implements CanActivate{
  constructor(private rs: RoleService){
  }
  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): MaybeAsync<GuardResult> {
      if (route.data[0] == this.rs.role){
        return true;
      }
      return false;
  }
};
