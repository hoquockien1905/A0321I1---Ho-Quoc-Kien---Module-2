import {CustomerType} from "./customer-type";

export interface Customer {
  id: number;
  name: string;
  dob: string;
  email: string;
  customertype: CustomerType;
}


