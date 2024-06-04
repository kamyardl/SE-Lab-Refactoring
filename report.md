<div dir="rtl">

## باز‌آرایی‌های انجام شده

- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/299b7e5e7c0be1d2dc82b1cc39ef4c4249886de5)
از Polymorphism به جای شرط استفاده شده است. برای این کار اینترفیس AddressType تعریف شده که متود toString را دارد و سه کلاس ImmediateAddress، DirectAddress و IndirectAddress آن را پیاده‌سازی می‌کنند.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/73c3432b44bf19cbde8c637cd051162d8a5574d4)
از الگوی Facade برای ساخت Address استفاده شده است. با توجه به اینکه ساخت Address در پکیج symbol وجود دا، استفاده از یک رابط برای ساخت راه‌حل بهتری است.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/f9ab89a0b0f94155ed25353ec96acede107a5787)
از الگوی Facade برای ساخت Token استفاده شده است. با توجه به اینکه ساخت Token در پکیج parser وجود داشت، استفاده از یک رابط برای ساخت راه‌حل بهتری است.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/a6c8f720089cbb84ee4fd93513373f41d553a296) صرفا بازآرایی‌های ساده‌ای داده شده است.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/d6fc5d963defdef2762d8f26615fbfd39025aa43) متود pushSymbolToStack استخراج شده است تا کد تکراری کمتر شود.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/7d6ee0b6f2c1ac882e2b2cc53a7ff3bcaecefe43) Separate Query From Modifier انجام شده است. یک متود به نام getMethod برای گرفتن تابع اضافه شده و سایر متودها صرفا تغییر لازم را انجام می‌دهند.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/4eb3b757e7cfe6eeb3d016a251488353305e955e) Self Encapsulated Field انجام شده است. برای attributeهای کلاس Parser متودهای setter و getter تعریف شده تا دسترسی به آنها فقط از طریق این متودها قابل انجام باشد.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/506639703ce98505b16bba8104bf2f71a67019c7) از inline method استفاده شده است که خوانایی کد را افزایش می‌دهد زیرا همان یک خط کد نسبت به تابع نوشته شده قابل فهم‌تر است.
- در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/65070b70e92187cf4fde3591babdeb77fc38301c) متود pushToStack استخراج شده است تا از کد تکراری جلوگیری شود.
- و نهایتا در این [کامیت](https://github.com/kamyardl/SE-Lab-Refactoring/commit/c088360f68174a71ef971da16e689aa8d8ec944d) formatter به پروژه اضافه شده است و با استفاده از آن پروژه ریفرمت شده است.

### توضیح مفاهیم

- **کد تمیز**
  کد تمیز به کدی گفته می‌شود که خواندن، درک و نگهداری آن آسان باشد.

- **بدهی فنی**
  بدهی فنی به هزینه‌های انباشته شده ناشی از استفاده از راه‌های میانبر در توسعه نرم‌افزار اشاره دارد که ممکن است نیاز به بازآرایی آینده داشته باشد.

- **بوی بد**
  بوی بد نشانه‌ای در کد است که ممکن است چیزی اشتباه باشد و نیاز به بازآرایی برای بهبود کیفیت کد داشته باشد.

### پنج دسته بوی بد کد

1. **Bloaters**
   - Bloaters بوی بدهایی هستند که به دلیل بزرگ و پیچیده شدن بیش از حد کد، متدها یا کلاس‌ها به وجود می‌آیند و کار با آن‌ها سخت می‌شود.

2. **Object-Orientation Abusers**
   - این بوهای بد زمانی به وجود می‌آیند که کد به درستی از اصول شی‌گرایی استفاده نکند، مانند استفاده نادرست از ارث‌بری و عدم کپسوله‌سازی داده‌ها.

3. **Change Preventers**
   - این بوهای بد زمانی به وجود می‌آیند که ساختار کد به گونه‌ای است که تغییر در آن سخت می‌شود و مجبور به تغییر در سایر بخش‌های کد نیز هستیم.

4. **Dispensables**
   - Dispensables عناصر غیرضروری در کد هستند، مانند کد تکراری، کلاس‌های بی‌فایده و کدی که می‌توان بدون تاثیر بر برنامه حذف کرد.

5. **Couplers**
   - Couplers بوهای بدی هستند که نشان‌دهنده اتصال بیش از حد بین کلاس‌ها یا ماژول‌ها هستند و باعث می‌شوند که آن‌ها بیش از حد به یکدیگر وابسته باشند و تغییر مستقل آن‌ها سخت شود.

### بوی بد Lazy Class

- **دسته‌بندی**
  Lazy Class نوعی از بوی بد **Dispensables** است.

- **بازآرایی‌های پیشنهادی برای رفع Lazy Class**
  - **Inline Class**: اگر کلاس به اندازه کافی کوچک است می‌توان در خط‌های کمی به صورت یکجا کلاس را پیاده‌سازی کرد.
  - **Collapse Hierarchy**: اگر زیرکلاس یا سوپرکلاس کار زیادی انجام نمی‌دهند، می‌توان اعضای آن‌ها را در یک کلاس ادغام کرد.

- **زمان نادیده گرفتن Lazy Class**
  - این بو را زمانی نادیده بگیرید که انتظار می‌رود کلاس در آینده رشد کرده و مسئولیت‌های بیشتری بگیرد که ارزش جدا نگه داشتن آن را دارد.

### بوهای بد در پروژه تبدیل کننده مدل به C

1. **Large Class** در فایل `src/com/project/Main.java` یا فایل `src/com/project/phase2CodeGeneration/Phase2CodeFileManipulator.java`
2. **Long Method** در فایل `src/com/project/Main.java` یا فایل `src/com/project/lexicalAnalyzer/LexicalAnalyzer.java` 
3. **Data Class** در فایل `src/com/project/graphBaseDependency/DependencyEdge.java`
4. **Switch Statements** در فایل `src/com/project/lexicalAnalyzer/LexicalAnalyzer.java`
5. **Comments**: کامنت‌های بی‌معنی زیاد در پروژه
6. **Long Parameter List**: به طور مثال در تابع addToTable
7. **Duplicate Code**
8. **Feature Envy**
9. **Lazy Function**: به طور مثال در تابع generateSelectArg
10. **Data Clump**
### پلاگین Formatter

- **عملکرد**
  یک پلاگین formatter به صورت خودکار کد را به نحوی که مطابق با یک سبک کدنویسی و استانداردهای مشخص باشد، بازآرایی می‌کند.

- **چرا مفید است**
  این پلاگین به حفظ یکنواختی و خوانایی در سراسر کد کمک می‌کند، که فهم و تغییر آن را آسان‌تر می‌سازد.

- **ارتباط با بازآرایی کد**
  در حالی که یک formatter به یکنواختی سبک کدنویسی کمک می‌کند، بازآرایی ساختار داخلی کد را بدون تغییر رفتار خارجی بهبود می‌بخشد. هر دو به تمیزتر و قابل نگهداری‌تر شدن کد کمک می‌کنند.

</div>
