import { Component, OnInit, ViewChild } from '@angular/core';
import { AluguelModel } from '../shared/models/aluguel.model';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { AluguelService } from '../shared/services/aluguel.service';

@Component({
  selector: 'app-aluguel',
  templateUrl: './aluguel.component.html',
  styleUrls: ['./aluguel.component.less']
})
export class AluguelComponent implements OnInit {
  @ViewChild('closeButton') closeButton: any;

  showAction: boolean = false;
  alugueis: Array<AluguelModel> = [];
  action: string = 'create';
  title: string = '';
  form: FormGroup = new FormGroup({
    automovel: new FormControl(''),
    statusContrato: new FormControl(''),
    valorAluguel: new FormControl(''),
    dataInicio: new FormControl(''),
    dataFim: new FormControl(''),
    valorCaucao: new FormControl('')
  });

  constructor(private aluguelService: AluguelService) { }

  ngOnInit(): void {
    this.getAlugueis();
  }

  salvar() {
    switch (this.action) {
      case 'create':
        this.aluguelService.create(this.form.value).then(resp => {
          this.getAlugueis();
          this.switchAction();
        }).catch(error => {
          this.switchAction();
        });
        break;

      default:
        break;
    }
  }

  setAction(action: string) {
    this.action = action;
    switch (action) {
      case 'create':
        this.title = 'Incluir Aluguel'
        this.showAction = true;
        break;

      default:
        break;
    }
  }

  getAlugueis() {
    this.aluguelService.getAll().then(resp => {
      this.alugueis = resp.content;
    })
  }

  switchAction() {
    this.showAction = false;
  }

}

