# Projeto FiapRide e Sistema de Eletrodomésticos

## Informações do Aluno
**Nome:** Leandro Filippini Aguiar Alves
**RM:**   568157
**Turma:** CCPB
**Curso:** Ciência da Computação 
**GitHub (username):** Leandro0805   

---

## Descrição do Projeto
Este repositório reúne a evolução prática dos meus estudos de Programação Orientada a Objetos (POO), integrando o projeto base de mobilidade urbana (FiapRide) com o desenvolvimento de um ecossistema próprio voltado ao gerenciamento de eletrodomésticos (Fogões, Fornos e Micro-ondas), aplicando os conceitos do nível básico ao avançado (Aulas 1 a 9).

---

## Checklist de Implementação
- [x] Aula 1 - Classes e Objetos
- [x] Aula 2 - Métodos e Regras de Negócio
- [x] Aula 3 - Encapsulamento
- [x] Aula 4 - Construtores e `this()`
- [x] Aula 5 - Associação entre Classes
- [x] Aula 6 - Herança (`extends`)
- [x] Aula 7 - Polimorfismo por Sobrescrita
- [x] Aula 8 - Classes e Métodos Abstratos
- [x] Aula 9 - Interfaces e Contratos Múltiplos

---

## Diagrama UML
Abaixo encontra-se o Diagrama de Classes estruturado no Astah, representando as classes, atributos, métodos, heranças e contratos de interface implementados no projeto:

![Class Diagram](docs/Class%20diagram.png)

---

## Perguntas de Reflexão

### Aula 1 - Classes e Objetos
**Pergunta:** "Por que precisamos criar uma classe Passageiro? Não seria mais fácil apenas criar variáveis soltas no main, como 'String nomeAna = "Ana"' e 'double saldoAna = 50.0'? Pense: E se o FiapRide tiver 1 milhão de usuários? Como a Classe ajuda a resolver isso?"  
**Resposta:**  
Se a gente usasse variáveis soltas, gerenciar os dados viraria um caos absoluto rapidinho. Com 1 milhão de usuários, seria impossível controlar milhares de variáveis espalhadas pelo código sem nenhuma coesão. A classe funciona exatamente como um molde: ela agrupa num só lugar tudo o que a entidade *é* (atributos) e tudo o que ela *faz* (métodos). Assim, a gente consegue instanciar quantos objetos precisar de forma padronizada, organizada e escalável.

### Aula 2 - Métodos
**Pergunta:** "Se nós podemos simplesmente fazer `passageiro.saldo = passageiro.saldo + 100` diretamente no código principal, por que dá tanto trabalho criar um método específico chamado `adicionarSaldo(valor)` para fazer isso? Quais seriam os riscos para a nossa startup de mobilidade se deixássemos qualquer programador alterar o saldo diretamente?"  
**Resposta:**  
Deixar o acesso livre para alterar atributos direto no código é abrir brecha para corromper os dados. O maior risco para a startup seria alguém passar um valor negativo por engano ou má-fé, quebrando o saldo do usuário. O método `adicionarSaldo()` age como um filtro de segurança: ele centraliza a regra de negócio, valida se o valor faz sentido e só então atualiza o estado do objeto de forma controlada.

### Aula 3 - Encapsulamento
**Pergunta:** "No nosso código, os atributos são `private`, mas os métodos `getSaldo()` e `getNome()` são `public`. Por que é seguro deixar o get público, mas perigoso deixar o atributo original público? Pense bem: Qual a diferença entre dar a alguém uma CÓPIA de um documento seu, e entregar o documento ORIGINAL para a pessoa rasurar?"  
**Resposta:**  
É exatamente essa a lógica da cópia vs. o original. O `get` devolve apenas uma leitura do dado para quem chamou, sem dar poder de alteração. Se o atributo fosse público (`public`), qualquer parte do código conseguiria sobrescrever a informação original sem passar por nenhuma validação. O encapsulamento com `private` garante que o objeto é dono dos seus próprios dados e só muda de estado através dos métodos seguros que ele mesmo disponibiliza.

### Aula 4 - Construtores
**Pergunta:** "Na nossa classe Veiculo, nós tomamos duas decisões arquitetônicas muito importantes: 1. Nós não criamos o método `setModelo()`. 2. O `setPlaca()` foi criado como privado, e criamos um método público chamado `atualizarPlaca()` para acessá-lo. Por que é um erro gravíssimo clicar em 'Gerar Getters e Setters para tudo automaticamente' na sua IDE? Como as nossas duas decisões acima protegem o sistema de fraudes e falhas de lógica?"  
**Resposta:**  
Gerar setters para tudo de forma automática é um vício perigoso porque ignora o mundo real. Um carro nasce com um modelo de fábrica e isso não deve mudar livremente, por isso o `setModel()` não existe. Da mesma forma, alterar uma placa não é um simples "atribuir valor", envolve regras e burocracia. Criar um método específico como `atualizarPlaca()` reflete uma regra de negócio real e impede que qualquer classe altere dados críticos de forma arbitrária.

### Aula 5 - Associação
**Pergunta:** "No construtor da Viagem, nós exigimos o objeto inteiro (Passageiro solicitante). Se o nosso resumo só precisa imprimir o nome da pessoa, não seria mais fácil e mais leve pedir apenas a String do nome no construtor da Viagem (`String nomeDoPassageiro`) em vez do objeto todo? Pense nas regras de negócio: O que acontece na hora que a Viagem acaba e o sistema precisa descontar o saldo? Se a Viagem tiver apenas a String 'Ana Silva', ela consegue mexer no dinheiro dela?"  
**Resposta:**  
Não conseguiria. Uma String é apenas um texto solto, ela não tem comportamento nem vínculo com a conta bancária do usuário. Ao passar o objeto `Passageiro` inteiro para a viagem, a gente estabelece uma relação real ("Tem-um"). Assim, quando a viagem termina, o sistema consegue acionar métodos do próprio passageiro (como descontar o valor da corrida do saldo dele), mantendo a lógica integrada e coesa.

### Aula 6 - Herança
**Pergunta:** "No nosso código, a mãe Veiculo possui os atributos placa e modelo como `private`. Quando o Carro herda de Veiculo, ele recebe esses atributos, mas o código dentro de Carro NÃO consegue fazer `this.placa = "ABC"`. Ele é obrigado a usar o `super()` ou o `setPlaca()`. Por que o Java não deixa a filha alterar as variáveis privadas da mãe diretamente? Qual o princípio das aulas passadas que isso está protegendo?"  
**Resposta:**  
Isso protege o pilar do Encapsulamento. Mesmo havendo herança, a classe filha não ganha passe livre para burlar as regras da superclasse. Se a filha pudesse mexer direto nos atributos `private` da mãe, ela poderia ignorar validações importantes. Obrigar o uso de `super()` ou de setters garante que a integridade dos dados da mãe seja sempre respeitada.

### Aula 7 - Polimorfismo
**Pergunta:** "No nosso loop `for (Veiculo veiculo : frota)`, a variável 'veiculo' é do tipo genérico Veiculo. Se esquecêssemos de criar o método `calcularAutonomia()` lá na classe mãe Veiculo, nós conseguiríamos chamá-lo dentro do loop, mesmo sabendo que ele existe dentro do Carro e da Moto? Por que o contrato precisa existir na base da hierarquia?"  
**Resposta:**  
Não daria certo. O compilador do Java é estático: ele olha para o tipo da *referência* (que é `Veiculo`), e não para o objeto concreto que tá rodando na memória. Se o método não estiver declarado na classe mãe, o compilador barra a execução achando que o objeto não possui aquele comportamento. O contrato precisa existir na base justamente para garantir que qualquer item da lista responda ao método.

### Aula 8 - Classes Abstratas
**Pergunta:** "Pense no mundo real: Faz sentido existir um objeto que é APENAS 'Veiculo' sem ser um tipo específico? Você já entrou em uma concessionária e comprou "um veiculo" genérico, sem ser carro, moto, caminhão ou nada disso? Por que, então, no código, precisamos EXPLICITAMENTE dizer ao Java que Veiculo é `abstract`? Pense: Se esquecermos de colocar abstract, qual o risco que corremos?"  
**Resposta:**  
Não faz sentido nenhum no mundo real. Ninguém compra "um veículo abstrato", compra um carro ou uma moto. Se a gente esquecesse de colocar `abstract`, o sistema permitiria dar um `new Veiculo()`, criando um objeto genérico vazio e sem regras específicas. A classe abstrata serve exatamente para travar isso, obrigando a modelagem a acontecer apenas através das classes filhas concretas.

### Aula 9 - Interfaces
**Pergunta:** "Por que Java permite herança simples (apenas uma mãe), mas múltipla implementação de interfaces (vários contratos)? Pense: Se CarroEletrico pudesse herdar de Veiculo E de Bateria ao mesmo tempo (herança múltipla), o que aconteceria se AMBAS as mães tivessem um método chamado `ligar()`? Como as interfaces resolvem esse problema?"  
**Resposta:**  
Se o Java permitisse herança múltipla de classes, cairíamos no clássico "Problema do Diamante": se duas mães tivessem métodos com o mesmo nome e códigos diferentes, o compilador entraria em conflito sem saber qual executar. As interfaces resolvem isso porque elas são contratos puros, ou seja, **não têm código dentro**. Como a interface só dita a assinatura do método, a classe filha implementa a lógica uma única vez, eliminando qualquer risco de colisão.

---

## Desafios Técnicos Implementados

### Desafio Pessoal (Domínio Escolhido)
- **Domínio:** Ecossistema de Eletrodomésticos de Cozinha (Fogões e Fornos).
- **Classes Criadas:** `Fogao` (Abstrata), `FogaoGas`, `FogaoInducao`, `Microondas`, `Proprietario`, e as interfaces `FuncaoForno` e `Temporizavel`.
- **Maior Desafio:** O ponto mais desafiador foi compreender a lógica da Aula 9 sobre *Múltiplos Tipos* e polimorfismo de interface. Consegui estruturar de forma que um `Microondas` (que pertence a uma árvore totalmente diferente de um `FogaoGas`) pudesse partilhar da mesma interface `FuncaoForno`, permitindo tratá-los de forma polimórfica num mesmo array.

---

## Conclusão
Essas 9 aulas mudaram completamente a minha visão sobre desenvolvimento. Aprendi que POO não é só decorar sintaxe, mas saber projetar arquiteturas limpas, proteger dados sensíveis com encapsulamento e desenhar contratos flexíveis. O conceito mais difícil foi virar a chave mental entre a herança tradicional (baseada em "o que a classe é") e as interfaces (baseadas em "o que a classe faz"), mas essa flexibilidade é, sem dúvida, o poder mais útil que aprendi a aplicar.s