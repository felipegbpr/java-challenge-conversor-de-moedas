<h1 align="center"> 💰Java Challenge - Conversor de Moedas</h1>
Este desafio aborda a criação de um programa Java que se conecta 
à API <a href="https://www.exchangerate-api.com//">ExchangeRate</a> para obter taxas de câmbio atualizadas entre diferentes moedas. O desafio faz parte do programa Oracle Next Education
com a colaboração entre Alura e Oracle. 

## 📷*Imagem de Exemplo*:
![Image](https://github.com/felipegbpr/projects-images/blob/main/currency-converter-image.png)

<br/>

## 🔎*Conceitos Abordados*
#### 📋Orientação a Objetos(POO): 
- **Classes e Objetos:** A estrutura do programa está baseada em classes e objetos para representar os diferentes componentes. Exemplos: Módulo de conexão com a API, e as respectivas moedas e conversões. 
  
- **Encapsulamento**: O encapsulamento é utilizado de maneira que as classes e métodos relacionados as moedas e conversões tenham as funcionalidades visivelmente estratégicas.

-  **Herança e Polimorfismo**: A hierarquia de classes é definida de maneira que seja possível realizar diferentes tipos de métodos para conversão das moedas disponíveis.


#### 🔌HTTP: 
- **Protocolo de Comunicação:** O programa realiza a conexão com a API <strong>ExchangeRate</strong> via Protocolo HTTP para obter os dados das taxas de câmbio.
  
- **METHODS**: É prossível realizar métodos do tipo ```GET``` para obter dados das taxas de câmbio e ```POST``` para enviar dados, se for necessário.


## ⚙️*Funcionalidades*:
- **Conexão com a API:** O estabelecimento de conexão do programa com a API <strong>ExchangeRate</strong> é realizado por meio do protocolo
HTTP para realizar a obtenção das taxas de câmbio que serão retornadas como um ```JsonObject``` dentro do programa.

- **Obtenção das Taxas de Câmbio**: O programa obtém as taxas de câmbio fornecidas pela API em tempo real via requisição HTTP.

- **Conversão das Moedas**: É possível que o usuário insira a sigla das moedas de origem e destino, para realizar as conversões das taxas que estão disponíveis.    
