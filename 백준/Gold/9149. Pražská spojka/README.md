# [Gold IV] Pražská spojka - 9149 

[문제 링크](https://www.acmicpc.net/problem/9149) 

### 성능 요약

메모리: 65228 KB, 시간: 768 ms

### 분류

플로이드–워셜, 그래프 이론

### 문제 설명

<p>Dobrá informovanost o aktuální situaci je pro Policii velmi důležitá. V případě poruchy telekomunikačního vedení nemají mezi sebou jednotlivá stanoviště spojení, které tak musí být nahrazeno pomocí poslů. Každý posel může vyřídit vzkaz na daném místě a v daný okamžik. Přestože poslové používají moderních dopravních prostředků (bicyklů), je přeci jen při jejich práci velice důležité znát vzdálenost, na kterou je třeba zprávu dopravit. Proto musí posel vždy volit nejkratší cestu, aby dorazil do cíle své cesty co nejdříve. Kromě toho se někdy může stát, že některé veřejné komunikace není možné kvůli občanským nepokojům použít. V krajním případě se dokonce všechna stanoviště rozpadnou na dvě nebo i více skupin, mezi kterými není žádné spojení.</p>

<p>Policejní složky mají velmi propracovaný projekt infrastruktury, je vždy přesně dáno rozmístění stanovišť v terénu a vzdálenosti mezi nimi. Proto je možné zmapovat vzdálenosti mezi jednotlivými stanovišti a rozhodnout, která cesta je pro případného posla nejhorší. Podle ní se potom zjišťuje, jaká aktuálnost krizového zpravodajství může být zaručena.</p>

### 입력 

 <p>První řádek vstupního souboru obsahuje celé kladné číslo <var>Z</var>, za kterým následuje postupně <var>Z</var>zadání. Každé zadání začíná řádkem obsahujícím dvě čísla oddělená mezerou. Jsou to po řadě počet jednotek (stanovišť) <var>J</var>, 2 <= <var>J</var> <= 300 a počet existujících spojnic mezi nimi <var>S</var>, 0 <= <var>S</var> <= <var>J</var>.(<var>J</var>-1) / 2. Dále následuje <var>S</var> řádků, každý z nich obsahuje právě tři čísla oddělená mezerou. První dvě čísla udávají čísla spojených stanovišť (jednotky jsou číslovány od jedné do <var>J</var>) a třetí číslo je délka spojnice mezi nimi. Je přitom možné, aby mezi nimi existovala také kratší cesta, která vede přes některé jiné stanoviště. I takovou samozřejmě může posel využít. Žádná dvojice stanovišť se v rámci jednoho zadání nevyskytne dvakrát.</p>

### 출력 

 <p>Úkolem je najít takovou dvojici stanovišť, mezi kterými je maximální vzdálenost v případě použití nejkratší možné cesty. Cesta může vést pouze po zadaných spojnicích. Pro každé zadání vypíše program větu "<code>Nejvetsi vzdalenost je </code><var>V</var><code>.</code>", kde <var>V</var> je délka nejdelší cesty mezi dvěma stanovišti, mezi kterými nelze nalézt cestu kratší. Pokud by zadaná situace znamenala, že existuje alespoň jedna dvojice stanovišť taková, že mezi nimi neexistuje žádné spojení, vypíše program místo toho větu "<code>Bez spojeni neni veleni!</code>".</p>

