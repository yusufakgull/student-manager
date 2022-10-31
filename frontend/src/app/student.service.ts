import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http'
import { Observable } from 'rxjs';
import { Student } from './student';
import { environment } from 'src/environments/environment';
@Injectable({
  providedIn: 'root'
})
export class StudentService {

  private baseUrl =environment.apiBaseUrl;
  constructor(private http: HttpClient) { }


  public getStudents() : Observable<Student[]>{
    return this.http.get<Student[]>(`${this.baseUrl}/students`);
  }

  public getStudent(studentId : number) : Observable<Student>{
    return this.http.get<Student>(`${this.baseUrl}/student/${studentId}`);
  }

  public addStudent(student : Student) : Observable<Student>{
    return this.http.post<Student>(`${this.baseUrl}/student`,student);
  }

  public updateStudent(student : Student) : Observable<Student>{
    return this.http.put<Student>(`${this.baseUrl}/student`,student);
  }

  public deleteStudent(studentId : number) : Observable<void>{
    return this.http.delete<void>(`${this.baseUrl}/student/${studentId}`);
  }
}
