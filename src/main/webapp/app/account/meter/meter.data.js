var meter_additions = [
    {id: 0,name:'Número de caracteres',type:'Fixo',rate:'+(n*4)',count:0,bonus:0},
    {id: 1,name:'Letras maiúsculas',type:'Variável',rate:'+((len-n)*2)',count:0,bonus:0},
    {id: 2,name:'Letras minúsculas',type:'Variável',rate:'+((len-n)*2)',count:0,bonus:0},
    {id: 3,name:'Números',type:'Variável',rate:'+(n*4)',count:0,bonus:0},
    {id: 4,name:'Simbolos',type:'Fixo',rate:'+(n*6)',count:0,bonus:0},
    {id: 5,name:'Números ou simbolos no meio',type:'Fixo',rate:'+(n*2)',count:0,bonus:0},
    {id: 6,name:'Requisitos',type:'Fixo',rate:'+(n*2)',count:0,bonus:0}
];

var meter_deductions = [
    {id: 0,name:'Apenas letras',type:'Fixo',rate:'-n',count:0,bonus:0},
    {id: 1,name:'Apenas números',type:'Fixo',rate:'-n',count:0,bonus:0},
    {id: 2,name:'Caracteres repetidos',type:'Variável',rate:'-',count:0,bonus:0},
    {id: 3,name:'Caracteres maiúsculos consecurivos',type:'Fixo',rate:'-(n*2)',count:0,bonus:0},
    {id: 4,name:'Caracteres minúsculos consecurivos',type:'Fixo',rate:'-(n*2)',count:0,bonus:0},
    {id: 5,name:'Números consecutivos',type:'Fixo',rate:'-(n*2)',count:0,bonus:0},
    {id: 6,name:'Letras sequenciais (3+)',type:'Fixo',rate:'-(n*3)',count:0,bonus:0},
    {id: 7,name:'Números sequenciais (3+)',type:'Fixo',rate:'-(n*3)',count:0,bonus:0},
    {id: 8,name:'Simbolos sequenciais (3+)',type:'Fixo',rate:'-(n*3)',count:0,bonus:0},
];
