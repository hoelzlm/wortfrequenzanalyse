import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { Wortfrequenz } from '../../models/wortfrequenz.model';
import { AnalyseApiService } from '../../services/analyse-api.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-result',
  imports: [CommonModule, RouterModule],
  templateUrl: './result.component.html',
  styleUrl: './result.component.css'
})
export class ResultComponent {

  analyseResult$: Observable<Wortfrequenz[]> | null = null;

  constructor(private route: ActivatedRoute, private analyseService: AnalyseApiService) {
    const fileId: number | null = Number(this.route.snapshot?.paramMap?.get("id"));
    this.analyseResult$ = fileId ? analyseService.getWordfrequentAnalyseByFileName(fileId) : null;
  }

}
