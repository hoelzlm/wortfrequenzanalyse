import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class ErrorService {
  private readonly _errorMessage$ = new BehaviorSubject<string | undefined>(
    undefined
  );

  public readonly errorMessage$ = this._errorMessage$.asObservable();

  public setErrorMessage(value: string | undefined) {
    this._errorMessage$.next(value);
  }
}
