# 📱 Nome do Seu Projeto

> ⚠️ **Nota Importante:** Este aplicativo utiliza **dados mockados** para todas as suas funcionalidades e exibições.
> 🛠️ **Tecnologias:** Desenvolvido nativamente em **Kotlin** utilizando Jetpack Compose.
> 🔄 **Navegação:** A arquitetura de navegação foi implementada utilizando a biblioteca do Compose Navigation com suporte a objetos **Serializable** para a passagem segura de dados entre telas.

---

## 🗺️ Fluxo de Navegação (Figma)
Para entender a arquitetura de transição e o mapeamento de rotas do aplicativo, veja o diagrama de fluxo abaixo:

<p align="center">
  <img src="prints-kotlin/navegacao-kotlin.png" alt="Fluxo de Navegação Figma" width="300px"/>
</p>

---

## 📸 Telas do Aplicativo

Abaixo está a sequência cronológica de acesso às telas do aplicativo, iniciando pelo fluxo de introdução até a central de comandos (Home), de onde é possível navegar livremente entre os recursos principais.

### 1. Splash Screen
A porta de entrada do aplicativo. Responsável por carregar as configurações iniciais e exibir a identidade visual do projeto antes de direcionar o usuário para o onboarding.
<p align="center">
  <img src="prints-kotlin/splash.png" alt="Splash Screen" width="250px"/>
</p>

### 2. Introdução 1 (Intro 1)
Primeira tela do fluxo de onboarding. Apresenta uma proposta de valor inicial do app e contextualiza o propósito da aplicação para o usuário.
<p align="center">
  <img src="prints-kotlin/intro-1.png" alt="Introdução 1" width="250px"/>
</p>

### 3. Introdução 2 (Intro 2)
Segunda tela de onboarding, aprofundando os detalhes das ferramentas disponíveis e guiando o usuário sobre os benefícios de utilizar a plataforma.
<p align="center">
  <img src="prints-kotlin/intro-2.png" alt="Introdução 2" width="250px"/>
</p>

### 4. Transição para Home (Intro to Home)
Tela que serve como ponte final do onboarding, preparando a experiência e fazendo a transição suave para a área principal pós-boas-vindas.
<p align="center">
  <img src="prints-kotlin/intro-to-home.png" alt="Intro to Home" width="250px"/>
</p>

---

### 5. Home (Painel Principal)
O hub central do aplicativo. A partir desta tela, o usuário tem uma visão macro do sistema e pode acessar diretamente as três vertentes abaixo, além de retornar a ela facilmente a qualquer momento.
<p align="center">
  <img src="prints-kotlin/home.png" alt="Home Screen" width="250px"/>
</p>

#### 🔄 Subtelas Acessíveis a partir da Home:

* **Alertas:** Central de notificações e avisos críticos gerados pelo sistema para tomada de ação rápida.
* **Informações de Satélite (Info Satélite):** Exibição detalhada de dados técnicos, conexões e telemetria espacial mockada.
* **Monitoramento:** Painel visual e analítico para acompanhamento em tempo real dos indicadores monitorados pelo app.

<table align="center">
  <tr>
    <td align="center"><b>Central de Alertas</b></td>
    <td align="center"><b>Informações de Satélite</b></td>
    <td align="center"><b>Painel de Monitoramento</b></td>
  </tr>
  <tr>
    <td><img src="prints-kotlin/alertas.png" alt="Alertas" width="220px"/></td>
    <td><img src="prints-kotlin/infosatelite.png" alt="Info Satélite" width="220px"/></td>
    <td><img src="prints-kotlin/monitoramento.png" alt="Monitoramento" width="220px"/></td>
  </tr>
</table>

---
