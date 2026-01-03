# 📊 Gestão Tamias – Sistema de Controle Financeiro

O **Gestão Tamias** é um sistema de controle financeiro desenvolvido em **Java**, com foco em **organizações de pequeno e médio porte**, como igrejas, associações e departamentos internos.

O projeto foi criado com o objetivo de **praticar desenvolvimento back-end, modelagem de dados, regras de negócio e geração de relatórios**, simulando cenários reais de uso.

---

## 🎯 Objetivos do Projeto
- Consolidar conceitos de **Java e JDBC**
- Aplicar **arquitetura em camadas (DAO, Services, GUI)**
- Trabalhar regras de negócio e cálculos financeiros
- Desenvolver relatórios baseados em dados
- Criar uma base sólida para futura evolução em **análise de dados e automação**

---

## 🧩 Funcionalidades

### 💰 Controle Financeiro
- Registro de entradas e saídas com data, valor, tipo e membro responsável
- Categorização por tipo (ex: dízimo, oferta, despesas fixas)
- Cálculo automático de balanços e subtotais por tipo

### 👥 Gestão de Membros
- Cadastro de membros com nome, aniversário, batismo e registro de membresia
- Listagem com ordenação e filtros

### 📊 Relatórios Personalizados
- Relatórios financeiros por período
- Filtros por tipo de movimentação:
  - Somente entradas
  - Somente saídas
  - Movimentação geral
- Exibição de totais por tipo e saldo geral

---

## 🛠️ Tecnologias Utilizadas
- **Java**
- **PostgreSQL**
- **JDBC**
- **Gradle**
- IntelliJ IDEA / Eclipse

---

## 🧬 Arquitetura do Projeto

gestao_tamias/

└── aplication/

├── db/ → Conexão e gerenciamento do banco de dados

├── dao/ → Interfaces e implementações DAO

├── services/ → Regras de negócio

├── model/ → Entidades do sistema

├── gui/ → Interface gráfica

└── resources/ → Configurações (db.properties)



---

## 🧠 Aprendizados
- Organização de projetos Java em camadas
- Integração com banco de dados relacional
- Criação de relatórios financeiros
- Aplicação de lógica de programação e boas práticas
- Estruturação de código pensando em manutenção e evolução

---

## 🚀 Possíveis Evoluções
- Dashboards visuais
- Análises automatizadas de dados financeiros
- Integração com APIs externas
- Aplicação de conceitos de **data analysis e inteligência artificial**

---

## 📄 Licença
MIT License

🚧 Status do Projeto
Projeto em desenvolvimento contínuo, utilizado como base prática
para evolução em back-end, organização de código e análise de dados.

