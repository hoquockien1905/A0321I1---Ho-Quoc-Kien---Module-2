import {Division} from './division';

export interface Employee {
  id: number;
  name: string;
  email: string;
  phone: string;
  division: Division;
}
