import { Routes } from '@angular/router';
import { FileUploadComponent } from './components/file-upload/file-upload.component';
import { ResultComponent } from './components/result/result.component';

export const routes: Routes = [
    { path: "", redirectTo:'/upload', pathMatch: 'full' },
    { path: "upload", component: FileUploadComponent },
    { path: "result", component: ResultComponent },
    
];
