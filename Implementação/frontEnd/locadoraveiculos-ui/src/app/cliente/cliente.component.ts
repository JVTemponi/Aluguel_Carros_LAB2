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
  @ViewChild('closebutton') closebutton: any;

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
          this.closebutton.nativeElement.click();
        });
        break;
      case 'edit':
        this.clienteService.updateCliente(this.form.value).then(resp => {
          this.closebutton.nativeElement.click();
        });
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
        break;

      case 'edit':
        this.title = 'Editar Cliente'
        break;

      case 'create':
        this.title = 'Incluir Cliente'
        break;

      default:
        break;
    }
  }

  getClientes() {
    this.clienteService.getAllCliente().then(resp => {
      this.clientes = resp.content;
    }).catch(error => {
      console.log(error);
    })
  }

}
