# Padrões de Projeto e Convenções de Código - PeyDey

Este documento estabelece as diretrizes de arquitetura, convenções de nomenclatura e padrões de design aplicados ao projeto **PeyDey**. Todas as novas contribuições devem seguir estritamente estes padrões para manter o código limpo, consistente e de fácil manutenção.

---

## 1. Convenção de Nomenclatura: `snake_case`

### O que é `snake_case`?
`snake_case` é a convenção em que todas as palavras são escritas em letras **minúsculas**, separadas exclusivamente pelo caractere underline (`_`).

* **Exemplo correto:** `bg_category_icon_chat`, `label_earned_today_coffe`, `btn_add_pop`
* **Incorreto:** `bgCategoryIconChat` (camelCase), `bg-category-icon` (kebab-case)

### Por que o `snake_case` é obrigatório no Android XML?
O sistema de build do Android e a geração da classe `R` exigem que os nomes de arquivos nas pastas de recursos (`res/drawable/`, `res/layout/`, `res/values/`, etc.) e os IDs de componentes contenham apenas **letras minúsculas, números e underlines**. O uso de maiúsculas ou hífens em arquivos de recursos causa erro de compilação.

---

## 2. Padronização de Prefixos para Drawables e Recursos

Para manter a organização na pasta `res/drawable/` e facilitar o auto-complete no Android Studio, utilizamos prefixos padronizados:

| Prefixo | Finalidade | Exemplos no Projeto |
| :--- | :--- | :--- |
| `bg_` | **Backgrounds, shapes e molduras** | `bg_rounded_green.xml`, `bg_add_button.xml`, `bg_category_icon_chat.xml` |
| `ic_` | **Ícones e vetores SVG** | `ic_person.xml`, `ic_coffee.xml`, `ic_roll.xml`, `ic_chat.xml`, `ic_add.xml` |
| `category_` | **Estilos gerais de cards/categorias** | `category_card.xml` |

---

## 3. Padronização de IDs no XML Layout (`@+id/...`)

Os IDs dos componentes XML em `activity_main.xml` e demais layouts devem seguir a convenção de prefixo por tipo de componente + nome em `snake_case` + sufixo de contexto:

### Tabela de Prefixos de IDs:

* **Contêineres e Seções:**
  * `hero_banner`: Banner superior com título e perfil
  * `subcontent_banner`: Banner verde de saldo/ganhos
  * `categories_main_content`: Contêiner geral das categorias

* **Rótulos e Textos (`TextView`):**
  * `title_` ou `label_`:
    * `title_menu` (Título principal "PeiDay")
    * `label_text_menu` (Data atual)
    * `label_earned_today` ("Ganho hoje")
    * `label_amount_earned` ("R$: 24,21")
    * `label_categories` ("Categorias")

* **Ícones e Imagens (`ImageView`):**
  * `ic_`:
    * `ic_coffe` (Ícone da categoria Café)
    * `ic_roll` (Ícone da categoria Cagada remunerada)
    * `ic_chat` (Ícone da categoria Conversinha paralela)

* **Botões e Ações (`ImageButton` / `Button`):**
  * `btn_`:
    * `btn_add_coffe`
    * `btn_add_pop`
    * `btn_add_chat`

---

## 4. Análise e Estrutura do `activity_main.xml`

Consultando o arquivo `activity_main.xml`, a estrutura dos **cards de categoria** segue um padrão modular limpo:

```xml
<!-- Div card categoria café -->
<LinearLayout
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:layout_marginTop="10dp"
    android:background="@drawable/category_card"
    android:gravity="center_vertical"
    android:orientation="horizontal"
    android:padding="20dp">

    <!-- 1. Ícone com background temático -->
    <ImageView
        android:id="@+id/ic_coffe"
        android:layout_width="80dp"
        android:layout_height="80dp"
        android:background="@drawable/bg_category_icon_coffe"
        android:contentDescription="Café"
        android:padding="20dp"
        android:scaleType="fitCenter"
        android:src="@drawable/ic_coffee"/>

    <!-- 2. Textos (Título e Subtítulo) -->
    <LinearLayout
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:layout_marginStart="16dp"
        android:layout_weight="1"
        android:orientation="vertical">

        <TextView
            android:id="@+id/label_coffe"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textColor="#000000"
            android:textSize="16sp"
            android:textStyle="bold"
            tools:text="Cafés" />

        <TextView
            android:id="@+id/label_earned_today_coffe"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:textColor="#8A8A80"
            android:textSize="14sp"
            android:textStyle="bold"
            tools:text="2x Hoje - R$: 10,00" />
    </LinearLayout>

    <!-- 3. Botão de Ação -->
    <ImageButton
        android:id="@+id/btn_add_coffe"
        android:layout_width="48dp"
        android:layout_height="48dp"
        android:layout_marginStart="8dp"
        android:background="@drawable/bg_add_button"
        android:contentDescription="Add"
        android:src="@drawable/ic_add" />
</LinearLayout>
<!-- fim da div categoria café -->
```

### Regras de Organização do Layout:
1. **Comentários de Delimitação:** Todo card/módulo deve ter um comentário no início (`<!-- Div card ... -->`) e no final (`<!-- fim da div ... -->`).
2. **Reuso de Estilo com `category_card`:** Todos os cards usam o mesmo background container (`@drawable/category_card`).
3. **Backgrounds Individuais para Ícones:** Cada categoria possui seu próprio drawable de background (`bg_category_icon_coffe`, `bg_category_icon_roll`, `bg_category_icon_chat`).

---

## 5. Unidades de Medida e Tipografia

* **`dp` (Density-independent Pixels):** Usado obrigatoriamente para dimensões de componentes, margens (`layout_marginTop`, `layout_marginStart`) e espaçamentos (`padding`).
* **`sp` (Scale-independent Pixels):** Usado obrigatoriamente para tamanhos de texto (`textSize`).
* **`textStyle="bold"` + `textFontWeight`:** Garantem o peso da fonte em diferentes versões do Android.
