import { Component, OnInit } from '@angular/core';
import { ApiService } from '../api.service';
@Component({
  selector: 'app-news',
  templateUrl: './news.component.html',
  styleUrls: ['./news.component.scss']
})
export class NewsComponent implements OnInit {
  articles;
  SEARCH_QUERY = '';
  constructor(private apiService: ApiService) { }
  
  ngOnInit() {
    this.apiService.getNews('tech').subscribe((data)=>{
      console.log(data);
      this.articles = data['articles'];
    });
  }

  updateNews(data) {
    this.articles = data;
  }

    
  submitSearchQuery() {
    this.apiService.getNews(this.SEARCH_QUERY).subscribe((data)=>{
      console.log(data);
      this.articles = data['articles'];
    });
}

}
