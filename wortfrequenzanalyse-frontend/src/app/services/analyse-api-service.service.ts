import { HttpClient, HttpEvent } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Wortfrequenz } from '../models/wortfrequenz.model';
import { UploadResponse } from '../models/uploadResponse.model';
import { environment } from '../../environments/environment.development';

@Injectable({
  providedIn: 'root'
})
export class AnalyseApiServiceService {
  baseUrl: string = environment.apiBaseUrl;
  basePort: string = environment.apiPort;

  constructor(private http: HttpClient) { }


  getWordfrequentAnalyseByFileName(fileName: string): Observable<Wortfrequenz[]> {
    const url: string = `http://${this.baseUrl}:${this.basePort}/api/v1/result?fileName=${fileName}`
    return this.http.get<Wortfrequenz[]>(url)
  }

  uploadFileToAnalyze(file: File): Observable<UploadResponse> {

    const formData = new FormData();
    formData.append('file', file);

    const url: string = `http://${this.baseUrl}:${this.basePort}/api/v1/upload`
    return this.http.post<UploadResponse>(url, formData)
  }

}
