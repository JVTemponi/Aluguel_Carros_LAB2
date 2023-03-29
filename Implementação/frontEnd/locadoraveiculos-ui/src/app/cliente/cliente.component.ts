import { Component, OnInit, ViewChild } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import { ClienteModel } from '../shared/models/cliente.model';
import { ClienteService } from '../shared/services/cliente.service';

@Component({
  selector: 'app-cliente',
  templateUrl: './cliente.component.html',
  styleUrls: ['./cliente.component.less']
})
export class ClienteComponent implements OnInit {
  @ViewChild('closeButton') closeButton: any;

  showModal: boolean = false;
  clientes: Array<ClienteModel> = [];
  action: string = '';
  title: string = '';
  form: FormGroup = new FormGroup({
    nome: new FormControl(''),
    cpf: new FormControl(''),
    cnh: new FormControl(''),
    nascimento: new FormControl(''),
    rendimentos: new FormControl(''),
    endereco: new FormControl(''),
    profissao: new FormControl('')
  });

  constructor(private clienteService: ClienteService) { }

  ngOnInit(): void {
    this.getClientes();
  }

  salvar() {
    switch (this.action) {
      case 'create':
        this.clienteService.saveCliente(this.form.value).then(resp => {
          this.closeButton.nativeElement.click();
        }).catch(error => {
          this.closeButton.nativeElement.click();
        });
        break;
      case 'edit':
        this.clienteService.updateCliente(this.form.value).then(resp => {
          this.closeButton.nativeElement.click();
        }).catch(error => {
          this.closeButton.nativeElement.click();
        });;
        break;

      default:
        break;
    }
  }

  setAction(action: string) {
    this.action = action;
    switch (action) {
      case 'view':
        this.title = 'Visualizar Cliente'
        this.showModal = true;
        break;

      case 'edit':
        this.title = 'Editar Cliente'
        this.showModal = true;
        break;

      case 'create':
        this.title = 'Incluir Cliente'
        this.showModal = true;
        break;

      default:
        break;
    }
  }

  getClientes() {
    this.clienteService.getAllCliente().then(resp => {
      this.clientes = resp;
    }).catch(error => {
      console.log(error);
    })
  }

  switchModal() {
    this.showModal = false;
  }

}
