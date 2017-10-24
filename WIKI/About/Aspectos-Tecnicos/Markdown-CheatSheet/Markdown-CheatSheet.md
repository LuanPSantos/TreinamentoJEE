
![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)


[About](../../About.md) :: [Aspectos Técnicos](../Aspectos-Tecnicos.md) :: [GitHub Markdown](Markdown-CheatSheet.md)

#  Linguagem de Margação MarkDown


A wiki utiliza a linguagem de marção **Mardown** com a extensão GitHub, **GFM** Github Flavored Markown. A mesma utilizada na wiki do github.

A especificação completa pode ser conferida em https://github.github.com/gfm/

Um visão resumida, pode ser consultada em https://guides.github.com/features/mastering-markdown/ e é base para esta página.

## Intro

Markdown is a lightweight and easy-to-use syntax for styling all forms of writing on the GitHub platform.

What you will learn:

- How the Markdown format makes styled collaborative editing easy
- How Markdown differs from traditional formatting approaches
- How to use Markdown to format text
- How to leverage GitHub’s automatic Markdown rendering
- How to apply GitHub’s unique Markdown extensions

### What is Markdown?

Markdown is a way to style text on the web. You control the display of the document; formatting words as bold or italic, adding images, and creating lists are just a few of the things we can do with Markdown. Mostly, Markdown is just regular text with a few non-alphabetic characters thrown in, like # or *.

### Syntax guide

Here’s an overview of Markdown syntax that you can use anywhere on GitHub.com or in your own text files.

#### Headers

# This is an `<h1>` tag
## This is an `<h2>` tag
###### This is an `<h6>` tag

#### Emphasis

*This text will be italic*
_This will also be italic_

**This text will be bold**
__This will also be bold__

_You **can** combine them_

#### Lists

Unordered

* Item 1
* Item 2
  * Item 2a
  * Item 2b

Ordered

1. Item 1
1. Item 2
1. Item 3
   1. Item 3a
   1. Item 3b

#### Images

![GitHub Logo](/images/logo.png)
Format: ![Alt Text](url)

#### Links

http://github.com - automatic!
[GitHub](http://github.com)

#### Blockquotes

As Kanye West said:

> We're living the future so
> the present is our past.

#### Inline code

I think you should use an
`<addr>` element here instead.

### GitHub Flavored Markdown

GitHub.com uses its own version of the Markdown syntax that provides an additional set of useful features, many of which make it easier to work with content on GitHub.com.

Note that some features of GitHub Flavored Markdown are only available in the descriptions and comments of Issues and Pull Requests. These include @mentions as well as references to SHA-1 hashes, Issues, and Pull Requests. Task Lists are also available in Gist comments and in Gist Markdown files.

#### Syntax highlighting

Here’s an example of how you can use syntax highlighting with GitHub Flavored Markdown:

```javascript
function fancyAlert(arg) {
  if(arg) {
    $.facebox({div:'#foo'})
  }
}
```

You can also simply indent your code by four spaces:

    function fancyAlert(arg) {
      if(arg) {
        $.facebox({div:'#foo'})
      }
    }

#### Tables

You can create tables by assembling a list of words and dividing them with hyphens - (for the first row), and then separating each column with a pipe |:

First Header | Second Header
------------ | -------------
Content from cell 1 | Content from cell 2
Content in the first column | Content in the second column


#### Automatic linking for URLs

Any URL (like http://www.github.com/) will be automatically converted into a clickable lin

k.

#### Strikethrough

Any word wrapped with two tildes (like ~~this~~) will appear crossed out.

_[Voltar para Documentação do Software](../../.../ReadMe.md)_


![Rodape](../../../ReadMe-Anexos/Rodape.png)
