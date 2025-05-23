# Задание 6 (Максимальная разница)

---

## Условия задания

В одной известной it-компании решили провести мероприятие для укрепления коллектива. Было проведено несколько игр на
знакомства и узнавание интересов.

В одной из игр всех сотрудников расставили в ряд, у каждого сотрудника известен рост, и у `i`-го работника он равен
`ai`. В
некоторые моменты игры два человека, которые стоят рядом, знакомились и выходили из ряда. После этого левая и правая
половина ряда сдвигались, чтобы не было пустоты между ними. Такое общение происходило до тех пор, пока в ряду есть хотя
бы два сотрудника.

Авторы игры решили, что чем больше разница между людьми, которые знакомятся, тем веселее. Поэтому они захотели найти
такой способ знакомства, чтобы суммарная разница роста людей, которые знакомятся, была как можно больше.

Так как они не программисты, а всего лишь авторы игр, то не знают, как найти лучший порядок. Помогите им решить эту
задачу.

## Формат входных данных

В первой строке входных данных дано число n - количество сотрудников `(2 ≤ n ≤ 3 * 10^5)`.

Во второй строке дан массив целых чисел `a1, a2, ..., an (1 ≤ ai ≤ 10^9)`.

## Формат выходных данных

Выведите наибольшую суммарную разницу в росте сотрудников, которые познакомятся.

## Примеры работы программы

---

### Пример 1

| ввод            | вывод |
|-----------------|-------|
| 4 </br> 1 2 4 3 | 4     |

### Пример 2

| ввод              | вывод |
|-------------------|-------|
| 5 </br> 2 1 4 5 2 | 6     |

---

## Примечания

В первом примере могут познакомиться сотрудники с ростом 2 и 4, затем сотрудники с ростом 1 и 3, тогда суммарная разница
будет |2 - 4| + |1 - 3| = 4.

