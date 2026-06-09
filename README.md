# 🚀 GS_POO_ESPACIAL

## Plataforma de Monitoramento de Sistemas Espaciais

Projeto desenvolvido para a **Global Solution 2026** da disciplina de **Programação Orientada a Objetos**, com o objetivo de simular uma plataforma de monitoramento de sistemas espaciais utilizando os principais conceitos de POO em Java.

---

## 📌 Sobre o Projeto

A proposta do projeto é criar um sistema via console capaz de monitorar componentes de uma missão espacial, realizar leituras simuladas de sensores, controlar sistemas de propulsão, gerenciar dados da missão e emitir alertas automáticos quando alguma condição crítica for detectada.

O sistema foi desenvolvido utilizando apenas **Java puro**, sem banco de dados, sem frameworks e sem interface gráfica, mantendo o foco principal nos conceitos fundamentais de **Programação Orientada a Objetos**.

---

## 🎯 Objetivo

Criar uma plataforma simples, funcional e organizada para demonstrar, na prática, os seguintes conceitos:

* Classe abstrata
* Interface
* Encapsulamento
* Herança
* Polimorfismo
* Sobrescrita de métodos
* Validação de dados
* Sistema de alertas
* Menu interativo via console

---

## 🛠️ Tecnologias Utilizadas

* Java
* Eclipse IDE
* Programação Orientada a Objetos
* Console com `Scanner`
* Geração de valores aleatórios com `java.util.Random`

---

## 📁 Estrutura do Projeto

```text
GS_POO_ESPACIAL/
└── src/
    └── gspoo/
        ├── ComponenteEspacial.java
        ├── Sensor.java
        ├── DadosMissao.java
        ├── SistemaPropulsao.java
        ├── PropulsaoQuimica.java
        ├── PropulsaoEletrica.java
        ├── SensorTemperatura.java
        ├── SensorPressao.java
        ├── SensorRadiacao.java
        └── SistemaMonitoramento.java
```

---

## 🧠 Conceitos de POO Aplicados

### 1. Classe Abstrata

A classe `ComponenteEspacial` representa um componente genérico do sistema espacial.

Ela possui atributos comuns, como:

* `id`
* `nome`
* `status`
* `temperatura`

Também possui métodos concretos:

* `ligar()`
* `desligar()`

E um método abstrato:

* `verificarStatus()`

Esse método abstrato obriga as classes filhas a implementarem sua própria forma de verificação.

---

### 2. Interface

A interface `Sensor` define um contrato obrigatório para todos os sensores do sistema.

Métodos definidos na interface:

```java
double lerValor();
boolean verificarFuncionamento();
String retornarTipo();
```

As classes que implementam essa interface são:

* `SensorTemperatura`
* `SensorPressao`
* `SensorRadiacao`

Cada sensor realiza uma leitura simulada e retorna mensagens adequadas conforme o valor gerado.

---

### 3. Encapsulamento

A classe `DadosMissao` demonstra encapsulamento ao manter todos os seus atributos como `private`.

Atributos protegidos:

* `coordenadas`
* `codigoAcesso`
* `combustivel`
* `trajetoria`
* `numeroTripulantes`

A classe possui getters e setters com validações, impedindo valores inválidos, como combustível negativo ou número negativo de tripulantes.

Além disso, as coordenadas da missão são protegidas por código de acesso.

Código padrão de acesso:

```text
GS2026
```

---

### 4. Herança

A classe abstrata `SistemaPropulsao` representa o modelo base para os sistemas de propulsão.

As classes filhas são:

* `PropulsaoQuimica`
* `PropulsaoEletrica`

Cada uma herda os atributos e métodos da classe mãe e sobrescreve o método `acelerar()` com comportamento próprio.

A propulsão química calcula empuxo com base em consumo de combustível.

A propulsão elétrica calcula empuxo com base em consumo de energia.

---

### 5. Polimorfismo

O projeto utiliza polimorfismo ao tratar diferentes sensores pelo tipo da interface `Sensor`.

Exemplo:

```java
Sensor[] sensores = {sensorTemperatura, sensorPressao, sensorRadiacao};
```

Também utiliza polimorfismo com os sistemas de propulsão:

```java
SistemaPropulsao[] propulsoes = {propulsaoQuimica, propulsaoEletrica};
```

Isso permite que objetos diferentes sejam manipulados de forma genérica, respeitando seus comportamentos específicos.

---

## ⚙️ Funcionalidades do Sistema

O sistema possui um menu interativo com as seguintes opções:

```text
1 - Verificar sensores
2 - Controlar propulsão
3 - Gerenciar dados da missão
4 - Simular alertas
5 - Exibir status completo
0 - Encerrar
```

---

## 📡 Sistema de Sensores

O projeto possui três sensores principais:

### Sensor de Temperatura

Gera valores simulados de temperatura e classifica o status em:

* Normal
* Atenção
* Alerta
* Crítico

Faixas utilizadas:

```text
Até 70 °C       -> Normal
71 °C a 85 °C  -> Atenção
86 °C a 95 °C  -> Alerta
Acima de 95 °C -> Crítico
```

---

### Sensor de Pressão

Gera valores simulados de pressão e verifica se o sistema está dentro da faixa segura.

Faixas utilizadas:

```text
Até 100 kPa       -> Normal
101 kPa a 115 kPa -> Atenção
116 kPa a 130 kPa -> Alerta
Acima de 130 kPa  -> Crítico
```

---

### Sensor de Radiação

Gera valores simulados de radiação e verifica o nível de risco.

Faixas utilizadas:

```text
Até 50 mSv       -> Normal
51 mSv a 65 mSv  -> Atenção
66 mSv a 80 mSv  -> Alerta
Acima de 80 mSv  -> Crítico
```

---

## 🔥 Sistema de Alertas

O sistema identifica automaticamente quando os valores ultrapassam os limites definidos.

Níveis de alerta utilizados:

* `ATENÇÃO`
* `ALERTA`
* `CRÍTICO`

Exemplo de saída no console:

```text
Temperatura simulada: 98 °C -> CRÍTICO: superaquecimento detectado. Ação urgente necessária!
Pressão simulada: 135 kPa -> CRÍTICO: pressão extremamente alta. Risco para o sistema!
Radiação simulada: 85 mSv -> CRÍTICO: radiação perigosa. Ativar protocolo de segurança!
Combustível simulado: 15% -> ALERTA: combustível abaixo de 20%.
```

---

## 🛰️ Sistema de Propulsão

O sistema permite controlar dois tipos de propulsão:

### Propulsão Química

Funcionalidades:

* Ligar motor
* Desligar motor
* Acelerar de 0 a 100%
* Calcular empuxo
* Calcular consumo de combustível

Exemplo:

```text
Potência ajustada para 50,00%
Propulsão química ativada.
Consumo de combustível: 40,00 L/min
Empuxo gerado: 75000,00 N
```

---

### Propulsão Elétrica

Funcionalidades:

* Ligar motor
* Desligar motor
* Acelerar de 0 a 100%
* Calcular empuxo
* Calcular consumo de energia

Exemplo:

```text
Potência ajustada para 50,00%
Propulsão elétrica ativada.
Consumo de energia: 60,00 kWh
Empuxo gerado: 35000,00 N
```

---

## 🔐 Dados da Missão

A classe `DadosMissao` gerencia informações importantes da missão espacial.

Dados armazenados:

* Coordenadas
* Código de acesso
* Nível de combustível
* Trajetória
* Número de tripulantes

As coordenadas são protegidas por código de acesso.

Caso o código esteja incorreto, o sistema retorna:

```text
ACESSO NEGADO: código de acesso incorreto.
```

Caso o combustível esteja abaixo de 20%, o sistema retorna:

```text
ALERTA: combustível abaixo de 20%. Planejar reabastecimento ou economia de energia.
```

---

## ▶️ Como Executar o Projeto no Eclipse

1. Abra o Eclipse IDE.
2. Clique em `File`.
3. Clique em `Import`.
4. Escolha `Existing Projects into Workspace`.
5. Selecione a pasta do projeto `GS_POO_ESPACIAL`.
6. Clique em `Finish`.
7. No Package Explorer, abra:

```text
src > gspoo > SistemaMonitoramento.java
```

8. Clique com o botão direito em `SistemaMonitoramento.java`.
9. Selecione:

```text
Run As > Java Application
```

10. O menu será exibido no console.

---

## 🧪 Como Testar

### Testar sensores

No menu principal, digite:

```text
1
```

O sistema exibirá as leituras dos sensores de temperatura, pressão e radiação.

---

### Testar propulsão elétrica

Digite a sequência:

```text
2
2
1
```

Essa sequência liga o motor elétrico.

Depois digite:

```text
2
2
3
50
```

Essa sequência acelera a propulsão elétrica com 50% de potência.

---

### Testar propulsão química

Digite a sequência:

```text
2
1
1
```

Essa sequência liga o motor químico.

Depois digite:

```text
2
1
3
50
```

Essa sequência acelera a propulsão química com 50% de potência.

---

### Testar dados protegidos

Digite:

```text
3
2
```

Depois informe o código:

```text
GS2026
```

O sistema exibirá as coordenadas da missão.

---

### Testar alertas

Digite:

```text
4
```

O sistema executará uma simulação com valores críticos de temperatura, pressão, radiação e combustível.

---

### Exibir status completo

Digite:

```text
5
```

O sistema exibirá o estado geral dos sensores, da propulsão e dos dados da missão.

---

## 📋 Classes do Projeto

| Classe                 | Função                                                          |
| ---------------------- | --------------------------------------------------------------- |
| `ComponenteEspacial`   | Classe abstrata base para componentes espaciais                 |
| `Sensor`               | Interface com os métodos obrigatórios dos sensores              |
| `SensorTemperatura`    | Sensor responsável por simular leituras de temperatura          |
| `SensorPressao`        | Sensor responsável por simular leituras de pressão              |
| `SensorRadiacao`       | Sensor responsável por simular leituras de radiação             |
| `DadosMissao`          | Classe responsável pelos dados protegidos e validados da missão |
| `SistemaPropulsao`     | Classe abstrata base para sistemas de propulsão                 |
| `PropulsaoQuimica`     | Classe filha que representa propulsão química                   |
| `PropulsaoEletrica`    | Classe filha que representa propulsão elétrica                  |
| `SistemaMonitoramento` | Classe principal com o menu interativo                          |

---

|   |   |
| - | - |

## 🧾 Exemplo de Execução

```text
========== PLATAFORMA DE MONITORAMENTO ESPACIAL ==========
1 - Verificar sensores
2 - Controlar propulsão
3 - Gerenciar dados da missão
4 - Simular alertas
5 - Exibir status completo
0 - Encerrar
==========================================================

Escolha uma opção: 1

--- VERIFICAÇÃO DOS SENSORES ---

Sensor de Temperatura
Valor lido: 57,08
Funcionamento: OK
Status: NORMAL: temperatura dentro do limite seguro.

Sensor de Pressão
Valor lido: 85,90
Funcionamento: OK
Status: NORMAL: pressão dentro da faixa segura.

Sensor de Radiação
Valor lido: 6,19
Funcionamento: OK
Status: NORMAL: radiação em nível aceitável.
```

---

## 📚 Aprendizados Demonstrados

Este projeto demonstra a aplicação prática dos principais pilares da Programação Orientada a Objetos:

### Abstração

Utilizada nas classes abstratas `ComponenteEspacial` e `SistemaPropulsao`.

### Encapsulamento

Aplicado na classe `DadosMissao`, com atributos privados e métodos de acesso controlados.

### Herança

Aplicada nas classes `PropulsaoQuimica`, `PropulsaoEletrica` e nos sensores que herdam de `ComponenteEspacial`.

### Polimorfismo

Aplicado ao manipular sensores por meio da interface `Sensor` e propulsores por meio da classe abstrata `SistemaPropulsao`.

---

## 👨‍💻 Autor

Gabriel Ramos moreira e Vinicius Siquera Melo

---

## 📌 Observação

Este projeto foi desenvolvido com foco acadêmico, priorizando clareza, organização, boas práticas de POO e compatibilidade com o nível de aprendizado de dois estudantes na FIAP.
