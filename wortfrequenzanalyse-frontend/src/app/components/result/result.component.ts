import { Component } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { Observable } from 'rxjs';
import { Wortfrequenz } from '../../models/wortfrequenz.model';
import { AnalyseApiServiceService } from '../../services/analyse-api-service.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-result',
  imports: [CommonModule, RouterModule],
  templateUrl: './result.component.html',
  styleUrl: './result.component.css'
})
export class ResultComponent {

  analyseResult$: Observable<Wortfrequenz[]> | null = null;

  constructor(private route: ActivatedRoute, private analyseService: AnalyseApiServiceService) {

    this.route.queryParams.subscribe(params => {
      const fileName: string = String(params['file']);
      this.analyseResult$ = analyseService.getWordfrequentAnalyseByFileName(fileName);
    })
  }

}
