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

  showAction: boolean = false;
  clientes: Array<ClienteModel> = [];
  clienteSelecionado: ClienteModel;
  action: string = 'edit';
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
          this.getClientes();
          this.switchAction();
        }).catch(error => {
          this.switchAction();
        });
        break;
      case 'edit':
        this.clienteService.updateCliente(this.form.value).then(resp => {
          this.getClientes();
          this.switchAction();
        }).catch(error => {
          this.switchAction();
        });;
        break;

      default:
        break;
    }
  }

  deletar(cliente: ClienteModel) {
    this.clienteService.deleteCliente(cliente.id).then(
      resp => this.getClientes()
    )
  }

  setAction(action: string, cliente: ClienteModel | null = null) {
    this.action = action;
    switch (action) {
      case 'view':
        this.title = 'Visualizar Cliente'
        if(cliente) 
          this.clienteSelecionado = cliente;
        this.showAction = true;
        break;

      case 'edit':
        this.title = 'Editar Cliente'
        if(cliente) 
          this.clienteSelecionado = cliente;
        this.showAction = true;
        break;

      case 'create':
        this.title = 'Incluir Cliente'
        this.showAction = true;
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

  switchAction() {
    this.showAction = false;
  }

  canSave(): boolean {
    return this.action !== 'view'
  }

}
