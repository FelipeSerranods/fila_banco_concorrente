# Simulador de Banco

Este projeto simula o atendimento de clientes em um banco, com o objetivo de analisar o tempo de espera e o tempo de atendimento durante um período de simulação. O sistema permite ajustar o número de caixas de atendimento e a duração da simulação, com a geração e o atendimento de clientes em threads separadas.

## Estrutura do Código

### 1. **SimuladorBanco.java**
- **Função**: Orquestra toda a simulação do banco, incluindo a criação de clientes, o gerenciamento da fila e o atendimento simultâneo por caixas.
- **Como funciona**: Inicia threads para o gerador de clientes e para os caixas, controlando a duração da simulação e gerando um relatório ao final.

### 2. **Caixa.java**
- **Função**: Representa um caixa de atendimento, que fica aguardando clientes da fila e realiza o atendimento de cada um.
- **Como funciona**: Cada caixa é uma thread que, quando iniciada, pega um cliente da fila, realiza o atendimento e registra o tempo de atendimento e de espera.

### 3. **Cliente.java**
- **Função**: Representa um cliente que chega ao banco e é atendido por um caixa.
- **Como funciona**: Armazena o tempo de chegada, o início do atendimento e o fim do atendimento. A partir dessas informações, calcula o tempo de espera, o tempo de atendimento e o tempo total no banco.

### 4. **FilaClientes.java**
- **Função**: Gerencia a fila de clientes aguardando para serem atendidos.
- **Como funciona**: Utiliza uma **BlockingQueue** para armazenar os clientes e garantir que o acesso à fila seja thread-safe.

### 5. **Estatisticas.java**
- **Função**: Coleta dados sobre o atendimento dos clientes e gera um relatório com as estatísticas da simulação.
- **Como funciona**: Armazena informações sobre o tempo de espera, tempo de atendimento e tempo total no banco. Calcula a média de espera, a média de atendimento e imprime o relatório final.

### 6. **GeradorDeClientes.java**
- **Função**: Gera clientes durante o tempo de simulação e os coloca na fila de espera.
- **Como funciona**: A cada intervalo de tempo, um novo cliente é criado e adicionado à fila. O intervalo entre a geração dos clientes é aleatório, mas controlado dentro de um limite de tempo.
