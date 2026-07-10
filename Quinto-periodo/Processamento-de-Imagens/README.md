# Processamento de Imagens

---
Matéria de Processamento Digital de Imagens (PDI): representação de imagens (formatos PNM — pbm/pgm/ppm), transformações de intensidade, equalização de histograma, morfologia matemática (binária e numérica), transformada de Fourier, segmentação (rotulação, watershed, k-means) e compressão (Huffman).

## Pastas

- **C**: código base da matéria em C — `codigoBase` calcula o negativo de uma imagem pgm-ascii e `utils` contém a `imagelib` para leitura e gravação de imagens;
- **Java**: versão em Java do código base — classes `Image` (leitura/escrita de pgm), `Transform` (negativo e convolução/filtro de média) e `Main`;
- **Python**: versões em Python (matplotlib/numpy) da leitura de pgm e da transformação negativo;
- **PDI-examples-master**: exemplos do professor usados no curso — negativo, intensidade, histograma, morfologia binária e numérica, contorno, distância, ponto isolado, rotulação, watershed, Fourier (discreta e FFT), k-means e Huffman;
- **reconstrucao_geodesica**: trabalho da matéria — reconstrução geodésica por morfologia matemática binária, usada para recuperar o texto de uma imagem a partir de uma máscara de marcadores;
- **pythonProject / teste**: pastas de teste com Python (a `teste` é apenas um ambiente virtual, sem código da matéria).
