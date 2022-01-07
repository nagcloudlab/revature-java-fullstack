import { Component } from '@angular/core';
import { Apollo, gql } from 'apollo-angular';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'ui';

  sessions!: any[];
  loading = true;
  error: any;

  constructor(private apollo: Apollo) { }

  ngOnInit() {
    this.apollo
      .watchQuery({
        query: gql`
          {
            sessions {
              title
              room
            }
          }
        `,
      })
      .valueChanges.subscribe((result: any) => {
        this.sessions = result?.data?.sessions;
        this.loading = result.loading;
        this.error = result.error;
      });
  }
}