import { Component, Input } from '@angular/core';
import { AnalyseApiServiceService } from '../../services/analyse-api-service.service';
import { HttpEventType } from '@angular/common/http';
import { Wortfrequenz } from '../../models/wortfrequenz.model';
import { UploadResponseStatus } from '../../models/uploadResponse.model';
import { Router } from '@angular/router';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-file-upload-component',
  imports: [CommonModule],
  templateUrl: './file-upload.component.html',
  styleUrl: './file-upload.component.css'
})
export class FileUploadComponent {

  requiredFileType: string = ".txt";
  file: File | null = null;

  status: string  = "Upload a file to analyze ..."
  loading: Boolean = false;

  constructor(private router: Router, private analyseService: AnalyseApiServiceService) {}

  onFileDrop(event: any) {
    event.preventDefault();
    event.stopPropagation();
    this.handleFile(event.dataTransfer.files[0]);
  }

  onFileSelected(event: any) {
    this.handleFile(event.target.files[0]);   
  }

  handleFile(file: File) {
    if (file.type != "text/plain") {
      console.log(file.type)
      console.error("wrong filetype ...")
    }

    if (file) {
      this.file = file
      this.status = file.name
    }
  } 

  analyzeFile() {
    if (this.file) {
      this.status = "Analyzing file ..."
      this.analyseService.uploadFileToAnalyze(this.file)
      .subscribe(response => {
        if(response.status == UploadResponseStatus.OK) {
          this.router.navigate(['/result'], {queryParams: {"file": response.message}})
        }
      });
    }
  }
}
