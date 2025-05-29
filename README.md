# 📊 Gestão Tamias

**Gestão Tamias** é um sistema de controle financeiro desenvolvido em Java com foco em pequenas e médias organizações, como igrejas, associações ou departamentos internos. O sistema permite o gerenciamento de movimentações financeiras, membros, categorias e geração de relatórios personalizados.

---

## 🧩 Funcionalidades

### 💰 Controle Financeiro
- Registro de **entradas** e **saídas** com data, valor, tipo e membro responsável.
- Categorização por tipo (ex: dízimo, oferta, despesas fixas).
- Cálculo de **saldos automáticos** e **subtotais** por tipo.

### 👥 Gestão de Membros
- Cadastro de membros com nome, aniversário, batismo e registro de membresia.
- Listagem com ordenação e filtros.

### 📊 Relatórios Personalizados
- Relatórios financeiros por **período** e **tipo de movimentação**:
  - Somente entradas
  - Somente saídas
  - Movimentação geral (entradas e saídas)
- Exibição de totais por tipo e saldo geral.

### 🧾 Relacionamento com Tipos
- As movimentações fazem referência às tabelas `tipoentrada` e `tiposaida` para organização por categorias.

---

## 🛠️ Tecnologias Utilizadas

| Camada               | Tecnologia         |
|----------------------|--------------------|
| Linguagem            | Java               |
| Banco de Dados       | PostgreSQL         |
| Acesso a Dados       | JDBC               |
| Build Tool           | Gradle             |
| IDE Recomendada      | IntelliJ IDEA ou Eclipse |

---

## 🧪 Como Executar o Projeto

### 🔁 1. Clonar o repositório

```bash
git clone https://github.com/JhonathanDarly/gestao_tamias.git
cd gestao_tamias/aplication

🗃️ 2. Criar o banco de dados PostgreSQL
Acesse seu PostgreSQL (via terminal ou ferramenta como pgAdmin) e execute:

sql
Copiar
Editar
CREATE DATABASE gestao_tamias;
CREATE USER tamias_user WITH ENCRYPTED PASSWORD 'senha123';
GRANT ALL PRIVILEGES ON DATABASE gestao_tamias TO tamias_user;
⚠️ Altere os dados conforme necessário para sua máquina.

⚙️ 3. Configurar o arquivo db.properties
No diretório aplication/resources/, crie (ou edite) o arquivo db.properties com o conteúdo:

properties
Copiar
Editar
db.url=jdbc:postgresql://localhost:5432/gestao_tamias
db.user=tamias_user
db.password=senha123
💡 A classe DB.java carrega automaticamente essa configuração para estabelecer a conexão com o banco de dados.

▶️ 4. Rodar o projeto
📦 Compilar e executar via terminal:
bash
Copiar
Editar
./gradlew build
java -jar build/libs/aplication.jar
💻 Ou executar via IDE:
Abra o projeto na sua IDE favorita (IntelliJ ou Eclipse).

Localize e execute a classe Main.java.

🧬 Estrutura do Projeto
java
Copiar
Editar
gestao_tamias/
└── aplication/
    ├── src/
    │   ├── db/               ← Gerenciamento de conexão com banco (JDBC)
    │   ├── dao/              ← Interfaces e implementações DAO
    │   ├── gui/              ← Interface do usuário
    │   ├── model/            ← Entidades: Entrada, Saída, Membro, TipoEntrada etc.
    │   └── services/         ← Camada de serviço entre GUI e DAO
    └── resources/
        └── db.properties     ← Configuração de conexão com PostgreSQL
📄 Licença
Este projeto é licenciado sob os termos da MIT License. Veja o arquivo LICENSE para mais detalhes.

🤝 Contribuindo
Sinta-se à vontade para abrir issues ou enviar pull requests. Sugestões, melhorias e correções são sempre bem-vindas!
