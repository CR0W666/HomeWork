import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
@Injectable({
  providedIn: 'root'
})
export class ApiService {
  API_KEY = 'a19c3e259b1e474fa7488c2bd5f10860';
  constructor(private httpClient: HttpClient) { }

  public getNews(SEARCH_QUERY){
    console.log(SEARCH_QUERY);  
    return this.httpClient.get(`https://newsapi.org/v2/everything?q=${SEARCH_QUERY}&sortyBy=popularity&apiKey=${this.API_KEY}`);
  }
}
