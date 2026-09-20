# PeiDay

**Aplicativo Android de Controle e Estatísticas de Pausas no Expediente**

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)
![POO II](https://img.shields.io/badge/Disciplina-POO%20II-2E7D32?style=for-the-badge)

## Sobre o Projeto

O PeiDay é um aplicativo Android desenvolvido em Java para a disciplina de **Programação Orientada a Objetos II**. Ele registra o tempo gasto em pausas durante o expediente, como café, conversa, caminhada ou almoço, e converte esse tempo em valor financeiro estimado a partir do salário informado pelo usuário.

A partir dos registros, o sistema gera estatísticas como o tempo total em pausas, o dinheiro acumulado, a categoria mais frequente e a maior pausa registrada, além de um sistema de conquistas que adiciona gamificação ao uso. Uma pausa de café de cerca de 13 minutos para quem ganha R$ 34,50 por hora, por exemplo, resulta em aproximadamente R$ 7,36.

O objetivo acadêmico é aplicar os conceitos de orientação a objetos em um sistema completo, com interface mobile, persistência de dados, validações e relatórios, mantendo o escopo enxuto para ser funcional e fácil de demonstrar.

## Principais Funcionalidades

- Cadastro de perfil com salário mensal e carga horária (ou valor por hora direto)
- Cálculo automático do valor da hora, do minuto e do segundo de trabalho
- Categorias de pausa padrão e personalizadas, com ativação e desativação
- Registro de pausas com categoria, data, duração e valor estimado
- Histórico de registros com filtros por categoria e por data
- Exclusão de registros individuais
- Dashboard com totais, médias e maiores marcas
- Sistema de conquistas desbloqueáveis
- Validação de entradas (salário, carga horária, datas e nomes)
- Persistência local: os dados continuam salvos após fechar o aplicativo
- Tema claro e escuro

## Tecnologias Utilizadas

### Aplicação

![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Java](https://img.shields.io/badge/Java-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

- **Java** como linguagem principal
- **Android SDK** com layouts em **XML** para a interface
- **Gradle** para build e gerenciamento de dependências, com catálogo de versões
- Fontes personalizadas **Baloo 2** e **Inter**
- Testes unitários locais e testes instrumentados
- Organização em **MVC** (camadas simples)

### Persistência

- Armazenamento local no dispositivo, com formato definido conforme a evolução do projeto (JSON, CSV ou SQLite)
- Interface de repositório que permite trocar a implementação sem alterar o restante do sistema

## Estrutura do Projeto

```text
PeyDey/
├── PROJECT_STANDARDS.md                   # Documentação de padrões de código do projeto
├── build.gradle                           # Configuração de build da raiz
├── settings.gradle                        # Configurações do Gradle e inclusão do módulo :app
├── gradle.properties                      # Propriedades do Gradle
├── gradlew / gradlew.bat                  # Scripts do Gradle Wrapper
├── gradle/
│   ├── libs.versions.toml                 # Catálogo de versões de dependências
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
└── app/                                   # Módulo principal da aplicação Android
    ├── build.gradle                       # Configurações de build do aplicativo (dependencies, SDK, etc.)
    └── src/
        ├── main/                          # Código de produção e recursos do app
        │   ├── AndroidManifest.xml        # Manifesto com declarações de Activities e permissões
        │   ├── java/
        │   │   └── com/example/peydey/    # Pacote Java dos códigos da aplicação
        │   │       ├── MainActivity.java      # Activity principal
        │   │       └── HomePageActivity.java  # Activity da página inicial
        │   └── res/                       # Recursos do projeto
        │       ├── drawable/              # Backgrounds e Ícones
        │       │   ├── bg_add_button.xml
        │       │   ├── bg_category_icon_chat.xml
        │       │   ├── bg_category_icon_coffe.xml
        │       │   ├── bg_category_icon_roll.xml
        │       │   ├── bg_rounded_green.xml
        │       │   ├── category_card.xml
        │       │   ├── ic_add.xml
        │       │   ├── ic_chat.xml
        │       │   ├── ic_coffee.xml
        │       │   ├── ic_launcher_background.xml
        │       │   ├── ic_launcher_foreground.xml
        │       │   ├── ic_person.xml
        │       │   └── ic_roll.xml
        │       ├── font/                  # Fontes personalizadas
        │       │   ├── baloo2.xml
        │       │   └── inter.xml
        │       ├── layout/                # Layouts XML das telas
        │       │   ├── activity_home_page.xml
        │       │   └── activity_main.xml
        │       ├── values/                # Valores Globais (Cores, Temas, Strings)
        │       │   ├── colors.xml
        │       │   ├── font_certs.xml
        │       │   ├── preloaded_fonts.xml
        │       │   ├── strings.xml
        │       │   └── themes.xml
        │       ├── values-night/          # Tema escuro
        │       │   └── themes.xml
        │       └── xml/                   # Regras de backup e dados
        │           ├── backup_rules.xml
        │           └── data_extraction_rules.xml
        ├── test/                          # Testes unitários locais
        │   └── java/com/example/peydey/
        │       └── ExampleUnitTest.java
        └── androidTest/                   # Testes de instrumentação/UI
            └── java/com/example/peydey/
                └── ExampleInstrumentedTest.java
```

## Instalação e Execução

### Pré-requisitos

- Android Studio (versão recente) com o Android SDK instalado
- JDK 17 ou superior
- Emulador Android ou dispositivo físico com depuração USB ativada
- Git

### Executando o projeto

```bash
git clone https://github.com/SEU_USUARIO/PeiDay.git
cd PeiDay
```

Abra a pasta no Android Studio, aguarde a sincronização do Gradle e execute o módulo `app` em um emulador ou dispositivo. Também é possível compilar e instalar pela linha de comando:

```bash
./gradlew assembleDebug
./gradlew installDebug
```

## Telas

O aplicativo tem navegação inferior entre Início, Histórico, Ranking e Conquistas, e o Perfil é acessado pelo ícone no topo da tela.

| Tela | Descrição |
| --- | --- |
| Login | Acesso com usuário e senha |
| Início | Ganho acumulado no dia, calculatedo a partir do valor por hora, e lista de categorias com botão para registrar uma pausa |
| Histórico | Registros agrupados por dia, com quantidade, dinheiro ganho e tempo gasto por categoria |
| Ranking | Comparativo entre usuários por categoria, em formato de pódio |
| Conquistas | Conquistas organizadas por categoria, com progresso e níveis |
| Perfil | Dados do usuário, conquistas em destaque e totais gerais |

## Categorias Padrão

| Categoria | Categoria | Categoria |
| --- | --- | --- |
| Café | Banheiro | Conversa |
| Caminhada | Celular | Descanso |
| Almoço | | |

O usuário também pode criar categorias personalizadas. Categorias inativas deixam de aparecer para novos registros, mas continuam no histórico.

## Conquistas

| Conquista | Critério |
| --- | --- |
| Primeiro Café | Registrar uma pausa de café |
| Primeiros R$ 10 | Acumular R$ 10 em pausas |
| Maratonista do Descanso | Registrar uma pausa acima de 30 minutos |
| Semana Consistente | Registrar pausas em 5 dias diferentes |

## Conceitos de POO Aplicados

| Conceito | Aplicação no PeiDay |
| --- | --- |
| Encapsulamento | Atributos privados com acesso por métodos controlados |
| Composição | `Usuario` possui registros; `RegistroPausa` possui `Categoria` |
| Herança | Conquistas específicas herdam de uma classe base `Conquista` |
| Polimorfismo | Cada conquista implementa seu próprio critério de verificação |
| Interface | Repositórios diferentes seguem o mesmo contrato |
| Tratamento de exceções | Validação de salário, carga horária e datas |
| Coleções | Listas de registros, categorias e conquistas |
| Persistência | Histórico salvo localmente no dispositivo |

## Escopo

O projeto cobre cadastro local de usuário, cálculos financeiros, categorias, registro de pausas, histórico, dashboard, conquistas básicas, persistência local e interface Android. Ficam fora do escopo autenticação online, ranking entre empresas, API pública, integrações com Slack, Teams ou smartwatch, backend separado e deploy em nuvem.

## Roadmap

- [x] Definição do escopo e da modelagem
- [x] Protótipo das telas
- [ ] Classes de domínio e cálculos de remuneração
- [ ] Persistência de perfil, categorias e registros
- [ ] Telas Android (login, início, histórico, ranking, conquistas e perfil)
- [ ] Dashboard e conquistas
- [ ] Apresentação final

## Melhorias Futuras

- Ranking entre colegas
- Exportação de dados para CSV
- Estatísticas mensais
- Conquistas personalizadas
- Versão web

## Desenvolvedor

**Flavio Kolenez**

[![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=github&logoColor=white)](https://github.com/SEU_USUARIO)
[![LinkedIn](https://img.shields.io/badge/LinkedIn-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://www.linkedin.com/in/SEU_PERFIL)
