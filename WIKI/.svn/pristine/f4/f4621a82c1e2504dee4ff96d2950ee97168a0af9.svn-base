![Cabecalho](../../../ReadMe-Anexos/Cabecalho.png)

[About](../../About.md) :: [Aspectos Técnicos](../Aspectos-Tecnicos.md) :: [Exportar-HTML](Exportar-HTML.md)

#  Página em Construção

## Converter para HTML

~~~sh
find . -iname "*.html" | xargs rm
for i in `find . -iname '*.md'`; do sed -i 's/<div style="color:green">//g' $i ; done
for i in `find . -iname '*.md'`; do sed -i 's/<div align="right">//g' $i ; done
for i in `find . -iname '*.md'`; do sed -i 's/<div\/>//g' $i ; done
for i in `find . -iname '*.md'`; do github-markdown $i > "$i".html --flavor gfm; done
for i in `find . -iname '*.md.html'`; do sed -i 's/.md/.html/g' $i ; done
for i in `find . -iname '*.md.html'`; do iconv -f UTF-8 -t ISO-8859-1 $i > $i.aux; done
find . -iname "*.html" | xargs rm
for i in `find . -iname '*.md.html.aux'`; do mv $i "."`echo $i | cut -d'.' -f 2`".html" ; done
find . -iname "*.md" | xargs rm
for i in `find . -iname '*.html'`; do sed 's/$/^M/g' $i ; done
~~~

### Tool-tips

#### Remover tags div:

1. Replace all: `<div\b[^>]*>` to ` `
2. Replace all: `</div>` to ` `

Remover qualquer TAG Html
Abertura: `<([A-Z][A-Z0-9]*)\b[^>]*>`
Fechamento: `</([A-Z][A-Z0-9]*)>`

Remover tag específica:
Abertura: `<img\b[^>]*>`
Fechamento: `</img>`

## Convert

Limpar

Converter de Linux para Windows

for i in `find . -iname '*.md'`; do sed 's/$/^M/g' $i ; done

## corrigir link dentro de div

~~~html
<div align="right"> [About - Modulo](../About/Organizacao-Fisica/Organizacao-Fisica/Modulo.md </div>

<div align="right"> <a href="../About/Organizacao-Fisica/Organizacao-Fisica/Modulo.md">About - Modulo</a>  </div>
~~~



_[Voltar para Documentação do Software](../../.../ReadMe.md)_


![Rodape](../../../ReadMe-Anexos/Rodape.png)
