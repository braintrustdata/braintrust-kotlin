# Changelog

## 0.4.0 (2025-12-03)

Full Changelog: [v0.3.0...v0.4.0](https://github.com/braintrustdata/braintrust-kotlin/compare/v0.3.0...v0.4.0)

### ⚠ BREAKING CHANGES

* **client:** extract auto pagination to shared classes
* **client:** **Migration:** - If you were referencing the `AutoPager` class on a specific `*Page` or `*PageAsync` type, then you should instead reference the shared `AutoPager` and `AutoPagerAsync` types, under the `core` package
    - If you were referencing `getNextPage` or `getNextPageParams`:
       - Swap to `nextPage()` and `nextPageParams()`
       - Note that these both now return non-nullable types (use `hasNextPage()` before calling these, since they will throw if it's impossible to get another page)
* **client:** refactor exception structure and methods ([#132](https://github.com/braintrustdata/braintrust-kotlin/issues/132))
* **client:** **Migration:** Previously you would access error JSON on an exception via `exception.error()._additionalProperties()`, which would return `Map<String, JsonValue>`. Now you would access this via `exception.body()`, which returns `JsonValue`. You should no longer assume that the returned error JSON is an object. You can check via `exception.body().asObject()`.
* **client:** refactor multipart formdata impl ([#99](https://github.com/braintrustdata/braintrust-kotlin/issues/99))
* **client:** **Migration:** 1. Builder methods that used to take `contentType` and `filename` as positional parameters after the main argument now no longer do. To set a custom `contentType` or `filename`, pass `MultipartField`, which can be constructed via `MultipartField.builder()`. 2. It's unlikely you were referencing it, but `MultipartFormValue` is now called `MultipartField` if you were.

### Features

* add retryable exception ([a2c54ff](https://github.com/braintrustdata/braintrust-kotlin/commit/a2c54fff92abe4d534dca53c8e2025d405cccc35))
* **api:** api update ([#50](https://github.com/braintrustdata/braintrust-kotlin/issues/50)) ([5e52131](https://github.com/braintrustdata/braintrust-kotlin/commit/5e521318ca6b5c34c75e917f1a5e42d086b2278d))
* **api:** api update ([#52](https://github.com/braintrustdata/braintrust-kotlin/issues/52)) ([c8a8e0e](https://github.com/braintrustdata/braintrust-kotlin/commit/c8a8e0e5196677b4e49038b5db881b1b01c3157d))
* **api:** api update ([#53](https://github.com/braintrustdata/braintrust-kotlin/issues/53)) ([b3c1bb2](https://github.com/braintrustdata/braintrust-kotlin/commit/b3c1bb2f7b82097792866386b22150e7b3b11b5a))
* **api:** api update ([#54](https://github.com/braintrustdata/braintrust-kotlin/issues/54)) ([9a85a86](https://github.com/braintrustdata/braintrust-kotlin/commit/9a85a862e084f405f6497c4f733a260af8a83872))
* **api:** manual updates ([#117](https://github.com/braintrustdata/braintrust-kotlin/issues/117)) ([b68f811](https://github.com/braintrustdata/braintrust-kotlin/commit/b68f81175a329e8a1b0dfc08e769fc32cbf8bd90))
* **api:** manual updates ([#118](https://github.com/braintrustdata/braintrust-kotlin/issues/118)) ([a820adb](https://github.com/braintrustdata/braintrust-kotlin/commit/a820adbbbe4fb32cfa3925bbdd645ad5b95014a0))
* **api:** manual updates ([#120](https://github.com/braintrustdata/braintrust-kotlin/issues/120)) ([4ef778b](https://github.com/braintrustdata/braintrust-kotlin/commit/4ef778ba5932835225c60f5f507c0025fa415e6b))
* **api:** manual updates ([#121](https://github.com/braintrustdata/braintrust-kotlin/issues/121)) ([093acc4](https://github.com/braintrustdata/braintrust-kotlin/commit/093acc4aba4c4b4fea67b606d83f31f68e046743))
* **api:** manual updates ([#75](https://github.com/braintrustdata/braintrust-kotlin/issues/75)) ([8f7b570](https://github.com/braintrustdata/braintrust-kotlin/commit/8f7b57048a316a8dc5606b84047ed269dda462f3))
* **api:** manual updates ([#77](https://github.com/braintrustdata/braintrust-kotlin/issues/77)) ([8732e08](https://github.com/braintrustdata/braintrust-kotlin/commit/8732e08757d82f5e82dfd6d61bf8ca0d69e15baa))
* **api:** manual updates ([#79](https://github.com/braintrustdata/braintrust-kotlin/issues/79)) ([5b6c4e5](https://github.com/braintrustdata/braintrust-kotlin/commit/5b6c4e511b61d00cbf7ffbab6bdbd8848211b43a))
* **api:** manual updates ([#80](https://github.com/braintrustdata/braintrust-kotlin/issues/80)) ([ecaf2ae](https://github.com/braintrustdata/braintrust-kotlin/commit/ecaf2ae89a33a162f75b86834ca229e025c197a5))
* **api:** manual updates ([#81](https://github.com/braintrustdata/braintrust-kotlin/issues/81)) ([72e13e2](https://github.com/braintrustdata/braintrust-kotlin/commit/72e13e216b5ec668bd170e0be2b3cecba4598466))
* **api:** manual updates ([#82](https://github.com/braintrustdata/braintrust-kotlin/issues/82)) ([b54f251](https://github.com/braintrustdata/braintrust-kotlin/commit/b54f251e1ada7538adf7ce67656f7cb2ca603c92))
* **api:** manual updates ([#83](https://github.com/braintrustdata/braintrust-kotlin/issues/83)) ([456fe14](https://github.com/braintrustdata/braintrust-kotlin/commit/456fe14c2dc726c306907eb4e3a56f94eb632386))
* **api:** manual updates ([#84](https://github.com/braintrustdata/braintrust-kotlin/issues/84)) ([7849b85](https://github.com/braintrustdata/braintrust-kotlin/commit/7849b858d7c6edec79d6584a53f5be2ccaaf5ace))
* **api:** manual updates ([#91](https://github.com/braintrustdata/braintrust-kotlin/issues/91)) ([29bee4e](https://github.com/braintrustdata/braintrust-kotlin/commit/29bee4eda1af9bc45d88ff99cffb118fed48b73c))
* **client:** accept `InputStream` and `Path` for file params ([#102](https://github.com/braintrustdata/braintrust-kotlin/issues/102)) ([d68c4ee](https://github.com/braintrustdata/braintrust-kotlin/commit/d68c4ee117512eb8095c7b2fdbb08973961e452a))
* **client:** add `{QueryParams,Headers}#put(String, JsonValue)` methods ([430e2f3](https://github.com/braintrustdata/braintrust-kotlin/commit/430e2f32cd9825597a6eb6b33ae34ea47ef7734c))
* **client:** add a `withOptions` method ([0599455](https://github.com/braintrustdata/braintrust-kotlin/commit/0599455e28b280d36dcd22eefd95233c978d0e92))
* **client:** add enum validation method ([1e676fb](https://github.com/braintrustdata/braintrust-kotlin/commit/1e676fb297914ce740c8fea2708bc624585dad01))
* **client:** add https config options ([789d35f](https://github.com/braintrustdata/braintrust-kotlin/commit/789d35f9cd6690919eed1c34e28bb4c2c2ad3fb9))
* **client:** allow configuring env via system properties ([4604608](https://github.com/braintrustdata/braintrust-kotlin/commit/4604608aecce306f042ae3acaf4fcef450ae8b1e))
* **client:** allow configuring timeouts granularly ([#97](https://github.com/braintrustdata/braintrust-kotlin/issues/97)) ([e92c8c8](https://github.com/braintrustdata/braintrust-kotlin/commit/e92c8c89970ad42f18b95aea2fb72c04fc19c4b3))
* **client:** allow providing some params positionally ([c543351](https://github.com/braintrustdata/braintrust-kotlin/commit/c54335174d22ad222d9baf176f252687faf74a6e))
* **client:** detect binary incompatible jackson versions ([#103](https://github.com/braintrustdata/braintrust-kotlin/issues/103)) ([2576b86](https://github.com/braintrustdata/braintrust-kotlin/commit/2576b865737f56bfaeb12a400a376b97224e6fbe))
* **client:** ensure compat with proguard ([42635ab](https://github.com/braintrustdata/braintrust-kotlin/commit/42635abb640511be1d954fd40e5a61260cd9ee5a))
* **client:** expose request body setter and getter ([#145](https://github.com/braintrustdata/braintrust-kotlin/issues/145)) ([9f61f5b](https://github.com/braintrustdata/braintrust-kotlin/commit/9f61f5bd1160c515abfebcf778fda26324fc5fc1))
* **client:** expose sleeper option ([dfcb76f](https://github.com/braintrustdata/braintrust-kotlin/commit/dfcb76f7827aac295d57767a5669d18b6cf0960b))
* **client:** extract auto pagination to shared classes ([12a94f0](https://github.com/braintrustdata/braintrust-kotlin/commit/12a94f0b0ec372b21edb91ec7019311669711166))
* **client:** implement per-endpoint base URL support ([1839ec8](https://github.com/braintrustdata/braintrust-kotlin/commit/1839ec8f1436b336b033c09e1894aa8a39d0a83b))
* **client:** make datetime deserialization more lenient ([#144](https://github.com/braintrustdata/braintrust-kotlin/issues/144)) ([e1abefb](https://github.com/braintrustdata/braintrust-kotlin/commit/e1abefb1c8a96d9149e57c08d04cfad6ff21a2ff))
* **client:** make pagination robust to missing data ([71968b4](https://github.com/braintrustdata/braintrust-kotlin/commit/71968b4109ba33d824a9dbdf7567aa90b7b0ff6a))
* **client:** make union deserialization more robust ([#143](https://github.com/braintrustdata/braintrust-kotlin/issues/143)) ([1e676fb](https://github.com/braintrustdata/braintrust-kotlin/commit/1e676fb297914ce740c8fea2708bc624585dad01))
* **client:** support a lower jackson version ([#137](https://github.com/braintrustdata/braintrust-kotlin/issues/137)) ([8fe19ac](https://github.com/braintrustdata/braintrust-kotlin/commit/8fe19ac1626f12461819857e5716bd1de3a514be))
* **client:** support raw response access ([#98](https://github.com/braintrustdata/braintrust-kotlin/issues/98)) ([402d7d4](https://github.com/braintrustdata/braintrust-kotlin/commit/402d7d4ba7447e1b8a2fb878480369526690e837))
* **client:** support setting base URL via env var ([a051a62](https://github.com/braintrustdata/braintrust-kotlin/commit/a051a62264ecc5c331df0674517249f5c2fa2b78))
* **client:** throw on incompatible jackson version ([8fe19ac](https://github.com/braintrustdata/braintrust-kotlin/commit/8fe19ac1626f12461819857e5716bd1de3a514be))
* generate and publish docs ([#104](https://github.com/braintrustdata/braintrust-kotlin/issues/104)) ([af10dfa](https://github.com/braintrustdata/braintrust-kotlin/commit/af10dfabe69cce01485d16534891e0fec0d2c2c9))


### Bug Fixes

* **ci:** release-doctor — report correct token name ([c4b98ad](https://github.com/braintrustdata/braintrust-kotlin/commit/c4b98adfe154dc1f470fffa70f37cc4d0c590fbe))
* **ci:** use java-version 21 for publish step ([e72ceec](https://github.com/braintrustdata/braintrust-kotlin/commit/e72ceec842fe5cd4019fdb1ff416e9256fb3f82b))
* **client:** accidental mutability of some classes ([ff29dfc](https://github.com/braintrustdata/braintrust-kotlin/commit/ff29dfcd127f51dac70aa31f4a3abec0120ded7b))
* **client:** bump max requests per host to max requests (5 -&gt; 64) ([267ec75](https://github.com/braintrustdata/braintrust-kotlin/commit/267ec753ab9a5efd0c5065de14bdb93168b4dc51))
* **client:** bump to better jackson version ([1ecc879](https://github.com/braintrustdata/braintrust-kotlin/commit/1ecc879a867b67629251c7ac899082753a1e3758))
* **client:** deserialization of empty objects ([0ffe055](https://github.com/braintrustdata/braintrust-kotlin/commit/0ffe0554d06ac07d439c61b46ef7e7a065cc4ed5))
* **client:** don't call `validate()` during deserialization if we don't have to ([#140](https://github.com/braintrustdata/braintrust-kotlin/issues/140)) ([4819d56](https://github.com/braintrustdata/braintrust-kotlin/commit/4819d5650518a5e02a33784af8a9b1e071a16d6e))
* **client:** don't close client on `withOptions` usage when original is gc'd ([f34eb56](https://github.com/braintrustdata/braintrust-kotlin/commit/f34eb564bdd06ae284e331b5f7dce5c5c303e345))
* **client:** ensure error handling always occurs ([9c943ae](https://github.com/braintrustdata/braintrust-kotlin/commit/9c943ae891f9e93fb56b292f46009448c9f23134))
* **client:** ensure single timer is created per client ([dfcb76f](https://github.com/braintrustdata/braintrust-kotlin/commit/dfcb76f7827aac295d57767a5669d18b6cf0960b))
* **client:** incorrect `getPackageVersion` impl ([c901eb6](https://github.com/braintrustdata/braintrust-kotlin/commit/c901eb680764b5e1e82576e547b52710d5ba08d9))
* **client:** limit json deserialization coercion ([#141](https://github.com/braintrustdata/braintrust-kotlin/issues/141)) ([346b726](https://github.com/braintrustdata/braintrust-kotlin/commit/346b7260ef162e4afaf2d6a0390c9ac43ef1fe63))
* **client:** map deserialization bug ([0092e84](https://github.com/braintrustdata/braintrust-kotlin/commit/0092e8412d90c313cf74c739e47e757ea97dca26))
* **client:** multi-value header serialization ([992e97d](https://github.com/braintrustdata/braintrust-kotlin/commit/992e97d6f7b3b745fad8f72575f45f34f5259879))
* **client:** r8 support ([3eeb5d5](https://github.com/braintrustdata/braintrust-kotlin/commit/3eeb5d5435cbf40488e6ea7d0a286ee2fffc28f6))
* **client:** support kotlin 1.8 runtime ([#129](https://github.com/braintrustdata/braintrust-kotlin/issues/129)) ([0437e08](https://github.com/braintrustdata/braintrust-kotlin/commit/0437e080354ad8a48d860f06863448be15097d3c))
* fix casing issue ([a2c6996](https://github.com/braintrustdata/braintrust-kotlin/commit/a2c6996b9017a38d552431894ab9fbb6fbc30e28))
* pluralize `list` response variables ([#142](https://github.com/braintrustdata/braintrust-kotlin/issues/142)) ([a82733e](https://github.com/braintrustdata/braintrust-kotlin/commit/a82733e731582a7b7a3e71c08cc06bae9be394e6))
* update singularization rules ([772887c](https://github.com/braintrustdata/braintrust-kotlin/commit/772887c2a2e904850458aaf0179b1f947ea8e68a))


### Performance Improvements

* **client:** cached parsed type in `HttpResponseFor` ([#147](https://github.com/braintrustdata/braintrust-kotlin/issues/147)) ([be273d1](https://github.com/braintrustdata/braintrust-kotlin/commit/be273d1bc370a9ae55adb28f99ca9f317fcd9cfc))
* **internal:** make formatting faster ([b8e05ea](https://github.com/braintrustdata/braintrust-kotlin/commit/b8e05ea9d384380e96d6aab61b78f76d4ad77e75))


### Chores

* **api:** manual updates ([#58](https://github.com/braintrustdata/braintrust-kotlin/issues/58)) ([a98c90c](https://github.com/braintrustdata/braintrust-kotlin/commit/a98c90c8a5e47b23a1346e3e5b476006011dc3e2))
* **ci:** add build job ([aa79cc8](https://github.com/braintrustdata/braintrust-kotlin/commit/aa79cc8908b94e9971719b8ba55ba94ffdf676f6))
* **ci:** add timeout thresholds for CI jobs ([a4be02a](https://github.com/braintrustdata/braintrust-kotlin/commit/a4be02a1cff356852fbcf9cf1e5bf793d2c39b70))
* **ci:** bump `actions/setup-java` to v4 ([ae504a3](https://github.com/braintrustdata/braintrust-kotlin/commit/ae504a3bd6f6d1dd460f7954773d3d1b7ea35dce))
* **ci:** enable for pull requests ([9883bd7](https://github.com/braintrustdata/braintrust-kotlin/commit/9883bd7f815d0fdb4a71d459dc9c707d5a32f2b8))
* **ci:** ensure docs generation always succeeds ([53f3fde](https://github.com/braintrustdata/braintrust-kotlin/commit/53f3fde57d20a74c012aaa62cff4e73bd4660c94))
* **ci:** only run for pushes and fork pull requests ([6fe433e](https://github.com/braintrustdata/braintrust-kotlin/commit/6fe433e3ce9ad421f6cbe36ea4b8e41b83d61ae3))
* **ci:** only use depot for staging repos ([c32ff0c](https://github.com/braintrustdata/braintrust-kotlin/commit/c32ff0caa5ab4d523fe2e1d1132454e7ba8d4218))
* **ci:** reduce log noise ([140ff0c](https://github.com/braintrustdata/braintrust-kotlin/commit/140ff0ccbb2e258ac933ec91c1bfe76df07aee6e))
* **client:** refactor closing / shutdown ([96dc010](https://github.com/braintrustdata/braintrust-kotlin/commit/96dc01044da36ffca689356e2eb779627d0fad88))
* **client:** refactor exception structure and methods ([#132](https://github.com/braintrustdata/braintrust-kotlin/issues/132)) ([d06a530](https://github.com/braintrustdata/braintrust-kotlin/commit/d06a530151dfb6acefe0f2ff8d2a3ca114a26d14))
* **client:** refactor multipart formdata impl ([#99](https://github.com/braintrustdata/braintrust-kotlin/issues/99)) ([b6cd77a](https://github.com/braintrustdata/braintrust-kotlin/commit/b6cd77af8a9a2aa167cf6c029c4bdd2b414bcd7f))
* **client:** remove unnecessary json state from some query param classes ([1e676fb](https://github.com/braintrustdata/braintrust-kotlin/commit/1e676fb297914ce740c8fea2708bc624585dad01))
* **deps:** bump jackson to 2.18.1 ([#86](https://github.com/braintrustdata/braintrust-kotlin/issues/86)) ([95066db](https://github.com/braintrustdata/braintrust-kotlin/commit/95066dba9029f273b2b0697f7e5cdb44cf09fed0))
* **docs:** grammar improvements ([149705f](https://github.com/braintrustdata/braintrust-kotlin/commit/149705f24b510a9f653bc20964499efd29498012))
* **example:** fix run example comment ([5177a6e](https://github.com/braintrustdata/braintrust-kotlin/commit/5177a6edab59d77cc314590b118e0cc50c2837b2))
* increase max gradle JVM heap to 8GB ([735ab96](https://github.com/braintrustdata/braintrust-kotlin/commit/735ab969460566d22647cb9d7e4b15add8bd95e1))
* **internal:** add `.kotlin` to `.gitignore` ([#105](https://github.com/braintrustdata/braintrust-kotlin/issues/105)) ([3a73e2e](https://github.com/braintrustdata/braintrust-kotlin/commit/3a73e2ee0156e1a621de677cc4dd55e4bce61833))
* **internal:** add generated comment ([#124](https://github.com/braintrustdata/braintrust-kotlin/issues/124)) ([3a85ba6](https://github.com/braintrustdata/braintrust-kotlin/commit/3a85ba64646c7fc3da1ffd1ae39ddc493a5fc458))
* **internal:** add invalid json deserialization tests ([1e676fb](https://github.com/braintrustdata/braintrust-kotlin/commit/1e676fb297914ce740c8fea2708bc624585dad01))
* **internal:** add json roundtripping tests ([1e676fb](https://github.com/braintrustdata/braintrust-kotlin/commit/1e676fb297914ce740c8fea2708bc624585dad01))
* **internal:** add lock helper ([1bfeedd](https://github.com/braintrustdata/braintrust-kotlin/commit/1bfeeddc0f9c3db43ffa8fb8f175168cac840878))
* **internal:** add missing release please block ([#131](https://github.com/braintrustdata/braintrust-kotlin/issues/131)) ([73bca42](https://github.com/braintrustdata/braintrust-kotlin/commit/73bca42614d506179d61c1d07851f75334c02c17))
* **internal:** add tests for `_headers()` ([#127](https://github.com/braintrustdata/braintrust-kotlin/issues/127)) ([37a409a](https://github.com/braintrustdata/braintrust-kotlin/commit/37a409a2b24f4c93f688dd71104a4dd2c40fed6d))
* **internal:** allow running specific example from cli ([b685ffd](https://github.com/braintrustdata/braintrust-kotlin/commit/b685ffdb17dcea9fcd193cbac2eabfc708622d0f))
* **internal:** bump ci test timeout ([cdb84ce](https://github.com/braintrustdata/braintrust-kotlin/commit/cdb84ce94258505395d6de7800cc971237339a07))
* **internal:** codegen related update ([c842666](https://github.com/braintrustdata/braintrust-kotlin/commit/c842666eb2d3acd34b9ed4f17d3fa76dc9b6eb26))
* **internal:** codegen related update ([a9f3ce0](https://github.com/braintrustdata/braintrust-kotlin/commit/a9f3ce024be5acefb194542199f0b4928bcc8343))
* **internal:** codegen related update ([af659ea](https://github.com/braintrustdata/braintrust-kotlin/commit/af659eabb00d6fbe6edc1edb6394c30dd228c8da))
* **internal:** codegen related update ([#110](https://github.com/braintrustdata/braintrust-kotlin/issues/110)) ([114138e](https://github.com/braintrustdata/braintrust-kotlin/commit/114138e9d321e29a46bcd951d40a2601b85b9416))
* **internal:** codegen related update ([#111](https://github.com/braintrustdata/braintrust-kotlin/issues/111)) ([3632207](https://github.com/braintrustdata/braintrust-kotlin/commit/363220747d20629427c07b7d2825a4022749d935))
* **internal:** codegen related update ([#112](https://github.com/braintrustdata/braintrust-kotlin/issues/112)) ([9a6b149](https://github.com/braintrustdata/braintrust-kotlin/commit/9a6b1490e83543617f6dbe78e0e7b2b5a3231570))
* **internal:** codegen related update ([#113](https://github.com/braintrustdata/braintrust-kotlin/issues/113)) ([29c3842](https://github.com/braintrustdata/braintrust-kotlin/commit/29c3842d83027fb676c808db33862310f278a2bb))
* **internal:** codegen related update ([#114](https://github.com/braintrustdata/braintrust-kotlin/issues/114)) ([9d96723](https://github.com/braintrustdata/braintrust-kotlin/commit/9d96723dc8c74ff28fbbbc0821a63a10ce1248ba))
* **internal:** codegen related update ([#115](https://github.com/braintrustdata/braintrust-kotlin/issues/115)) ([e471285](https://github.com/braintrustdata/braintrust-kotlin/commit/e471285b4c1bed4d8d9942340059a35ec18b823b))
* **internal:** codegen related update ([#134](https://github.com/braintrustdata/braintrust-kotlin/issues/134)) ([942c135](https://github.com/braintrustdata/braintrust-kotlin/commit/942c135e6b5a7753c820b075689497eff56b9261))
* **internal:** codegen related update ([#146](https://github.com/braintrustdata/braintrust-kotlin/issues/146)) ([e31b6eb](https://github.com/braintrustdata/braintrust-kotlin/commit/e31b6ebf389ab55e60ebb6c54b5655ac6287eb72))
* **internal:** codegen related update ([#87](https://github.com/braintrustdata/braintrust-kotlin/issues/87)) ([58407f3](https://github.com/braintrustdata/braintrust-kotlin/commit/58407f3b10ed5cd4ba69b9b906cd87a3cbb3d79f))
* **internal:** codegen related update ([#88](https://github.com/braintrustdata/braintrust-kotlin/issues/88)) ([e2385b2](https://github.com/braintrustdata/braintrust-kotlin/commit/e2385b2a3059526106171a29f818da8fb8e7f60a))
* **internal:** codegen related update ([#89](https://github.com/braintrustdata/braintrust-kotlin/issues/89)) ([7a1838c](https://github.com/braintrustdata/braintrust-kotlin/commit/7a1838c0a824aa4fa48e1948dc2d6dd3a02dad38))
* **internal:** codegen related update ([#95](https://github.com/braintrustdata/braintrust-kotlin/issues/95)) ([40ba4ff](https://github.com/braintrustdata/braintrust-kotlin/commit/40ba4ff8f243db6e3bd996fd3a2e1e7fcfd51dd5))
* **internal:** delete unused methods and annotations ([#138](https://github.com/braintrustdata/braintrust-kotlin/issues/138)) ([0092e84](https://github.com/braintrustdata/braintrust-kotlin/commit/0092e8412d90c313cf74c739e47e757ea97dca26))
* **internal:** dynamically determine included projects ([d7375bb](https://github.com/braintrustdata/braintrust-kotlin/commit/d7375bbcf4e6ee994e20a613d1931c2880b111f6))
* **internal:** expand CI branch coverage ([ebd3cbe](https://github.com/braintrustdata/braintrust-kotlin/commit/ebd3cbefe045a1277650170b8409ba41182a4c2a))
* **internal:** generate more tests ([21aff2b](https://github.com/braintrustdata/braintrust-kotlin/commit/21aff2bf59c9f67d8873318c6f2af6459acd1c04))
* **internal:** java 17 -&gt; 21 on ci ([7908cfe](https://github.com/braintrustdata/braintrust-kotlin/commit/7908cfe2a370cc23c281710bfae4f8a89905c170))
* **internal:** make multipart assertions more robust ([1c4b313](https://github.com/braintrustdata/braintrust-kotlin/commit/1c4b313004a2402143fc10e8f2798339ae2ea22f))
* **internal:** make test classes internal ([#123](https://github.com/braintrustdata/braintrust-kotlin/issues/123)) ([ed8cb24](https://github.com/braintrustdata/braintrust-kotlin/commit/ed8cb24750ed69a822188d1d05667c4b19de76d2))
* **internal:** reduce CI branch coverage ([34931ed](https://github.com/braintrustdata/braintrust-kotlin/commit/34931ed4b367ff26f45e92aadd0d9c94334a2a9e))
* **internal:** reduce proguard ci logging ([d9e31bd](https://github.com/braintrustdata/braintrust-kotlin/commit/d9e31bdc655ad95080a9e99abbc84c9d75bce01f))
* **internal:** reenable warnings as errors ([#106](https://github.com/braintrustdata/braintrust-kotlin/issues/106)) ([a2ece91](https://github.com/braintrustdata/braintrust-kotlin/commit/a2ece9177007f86fdfb625b971adc0bab1f21fd2))
* **internal:** refactor `ErrorHandlingTest` ([#96](https://github.com/braintrustdata/braintrust-kotlin/issues/96)) ([4ca424c](https://github.com/braintrustdata/braintrust-kotlin/commit/4ca424c0d4961d2dea99c5b7e97a83416413364c))
* **internal:** refactor delegating from client to options ([6a172fb](https://github.com/braintrustdata/braintrust-kotlin/commit/6a172fb0b958cab0b5dac3045f414afc44f3b865))
* **internal:** refactor enum query param serialization ([#130](https://github.com/braintrustdata/braintrust-kotlin/issues/130)) ([0f12e8a](https://github.com/braintrustdata/braintrust-kotlin/commit/0f12e8aad758e7c59c5081a9a654dce96ce4df0d))
* **internal:** refactor query param serialization impl and tests ([#126](https://github.com/braintrustdata/braintrust-kotlin/issues/126)) ([9fcd889](https://github.com/braintrustdata/braintrust-kotlin/commit/9fcd889f1e613deb236122807286e547339043ca))
* **internal:** reformat some tests ([#128](https://github.com/braintrustdata/braintrust-kotlin/issues/128)) ([21aff2b](https://github.com/braintrustdata/braintrust-kotlin/commit/21aff2bf59c9f67d8873318c6f2af6459acd1c04))
* **internal:** remove extra empty newlines ([#116](https://github.com/braintrustdata/braintrust-kotlin/issues/116)) ([461eeda](https://github.com/braintrustdata/braintrust-kotlin/commit/461eedaf86f21962accfaaf78b799385edbc9dfe))
* **internal:** remove flaky `-Xbackend-threads=0` option ([0ea5d66](https://github.com/braintrustdata/braintrust-kotlin/commit/0ea5d665dd7731e1b5bef3cf4f2bd81dd6698551))
* **internal:** remove unnecessary `[...]` in `[@see](https://github.com/see)` ([8199199](https://github.com/braintrustdata/braintrust-kotlin/commit/8199199658d0beffe0b98113a7e4833333a7608c))
* **internal:** remove unnecessary `assertNotNull` calls ([1c4b313](https://github.com/braintrustdata/braintrust-kotlin/commit/1c4b313004a2402143fc10e8f2798339ae2ea22f))
* **internal:** support passing arguments to test script ([a06c26e](https://github.com/braintrustdata/braintrust-kotlin/commit/a06c26e7fd6fc43a2ccbdc2bc0fcbb8f34d44167))
* **internal:** support running ktfmt directly ([08b97d9](https://github.com/braintrustdata/braintrust-kotlin/commit/08b97d9f8e5371a1988aff367e1510a0e1c30e80))
* **internal:** swap from `Builder().from(...)` to `toBuilder()` ([#139](https://github.com/braintrustdata/braintrust-kotlin/issues/139)) ([824e27f](https://github.com/braintrustdata/braintrust-kotlin/commit/824e27fa96754290044bddc887d8a5ea7a85c84c))
* **internal:** update comment in script ([0804ff2](https://github.com/braintrustdata/braintrust-kotlin/commit/0804ff2024c349c6fd690c9091c855b0da03841a))
* **internal:** update java toolchain ([e419cef](https://github.com/braintrustdata/braintrust-kotlin/commit/e419cef730c32bcee83a84fe01c50af6189cf8a1))
* **internal:** update variable names in tests ([#107](https://github.com/braintrustdata/braintrust-kotlin/issues/107)) ([9517ac1](https://github.com/braintrustdata/braintrust-kotlin/commit/9517ac1f7ae0701dbae774827c6dc6bea0d1c04d))
* minor change to tests ([#93](https://github.com/braintrustdata/braintrust-kotlin/issues/93)) ([5195a03](https://github.com/braintrustdata/braintrust-kotlin/commit/5195a030d173f78025f78c2fd0295db6a12e131f))
* rebuild project due to codegen change ([#55](https://github.com/braintrustdata/braintrust-kotlin/issues/55)) ([1aff44c](https://github.com/braintrustdata/braintrust-kotlin/commit/1aff44cfbfdf19e35476dfcb7734aaa3eb00c2b0))
* rebuild project due to codegen change ([#56](https://github.com/braintrustdata/braintrust-kotlin/issues/56)) ([e16106b](https://github.com/braintrustdata/braintrust-kotlin/commit/e16106b4164c1a8a3dc854c30582880cbbcf1169))
* rebuild project due to codegen change ([#57](https://github.com/braintrustdata/braintrust-kotlin/issues/57)) ([3a5fc1c](https://github.com/braintrustdata/braintrust-kotlin/commit/3a5fc1c9ac893651cbf5406df0b00af745f9665a))
* rebuild project due to codegen change ([#59](https://github.com/braintrustdata/braintrust-kotlin/issues/59)) ([fe5e454](https://github.com/braintrustdata/braintrust-kotlin/commit/fe5e454a393ebf9d3b0116a7490227b2541a4be0))
* rebuild project due to codegen change ([#60](https://github.com/braintrustdata/braintrust-kotlin/issues/60)) ([619fdf9](https://github.com/braintrustdata/braintrust-kotlin/commit/619fdf9e456883166f7a89e9bc4c1f2f7dc794db))
* rebuild project due to codegen change ([#61](https://github.com/braintrustdata/braintrust-kotlin/issues/61)) ([34224b4](https://github.com/braintrustdata/braintrust-kotlin/commit/34224b4930331a004fa40bd8f15b06403e428ab3))
* rebuild project due to codegen change ([#62](https://github.com/braintrustdata/braintrust-kotlin/issues/62)) ([8d3804c](https://github.com/braintrustdata/braintrust-kotlin/commit/8d3804cb4621d80e7f1c09b89958f14f6dbf0457))
* rebuild project due to codegen change ([#63](https://github.com/braintrustdata/braintrust-kotlin/issues/63)) ([e941f87](https://github.com/braintrustdata/braintrust-kotlin/commit/e941f87250538b188c968eb867c90005f5880fbb))
* rebuild project due to codegen change ([#64](https://github.com/braintrustdata/braintrust-kotlin/issues/64)) ([5b393df](https://github.com/braintrustdata/braintrust-kotlin/commit/5b393df9ff5ee7892e918ee67586c34a567c8adc))
* rebuild project due to codegen change ([#65](https://github.com/braintrustdata/braintrust-kotlin/issues/65)) ([c86f18b](https://github.com/braintrustdata/braintrust-kotlin/commit/c86f18b700d39b94e0eedca6cad824b78de1a7ca))
* rebuild project due to codegen change ([#66](https://github.com/braintrustdata/braintrust-kotlin/issues/66)) ([ffdfb6b](https://github.com/braintrustdata/braintrust-kotlin/commit/ffdfb6bbb0c7220349db6f14ff917f29a4087ce8))
* rebuild project due to codegen change ([#67](https://github.com/braintrustdata/braintrust-kotlin/issues/67)) ([ba8f527](https://github.com/braintrustdata/braintrust-kotlin/commit/ba8f527856a7481bffd1f6790e9cc4de316f1545))
* rebuild project due to codegen change ([#68](https://github.com/braintrustdata/braintrust-kotlin/issues/68)) ([d852b92](https://github.com/braintrustdata/braintrust-kotlin/commit/d852b923a2fb1b899c075ec39df795d761c49c07))
* rebuild project due to codegen change ([#69](https://github.com/braintrustdata/braintrust-kotlin/issues/69)) ([7a303e4](https://github.com/braintrustdata/braintrust-kotlin/commit/7a303e4b9f87fac3385fdfc235bd69d8ee85827b))
* rebuild project due to codegen change ([#71](https://github.com/braintrustdata/braintrust-kotlin/issues/71)) ([f7b50d0](https://github.com/braintrustdata/braintrust-kotlin/commit/f7b50d0e40a1df306fe8af6471ff6f22ae59809e))
* rebuild project due to codegen change ([#73](https://github.com/braintrustdata/braintrust-kotlin/issues/73)) ([d08c8b7](https://github.com/braintrustdata/braintrust-kotlin/commit/d08c8b7eb735eaf67bceee775f5e665b9a3fca83))
* rebuild project due to codegen change ([#74](https://github.com/braintrustdata/braintrust-kotlin/issues/74)) ([2ac019c](https://github.com/braintrustdata/braintrust-kotlin/commit/2ac019c76046e620a2f4096655e026855ce1d1ee))
* rebuild project due to codegen change ([#78](https://github.com/braintrustdata/braintrust-kotlin/issues/78)) ([f067007](https://github.com/braintrustdata/braintrust-kotlin/commit/f067007eabed1a85b1e12ed451d830403de6da70))
* remove memory upper bound from publishing step ([ad903a2](https://github.com/braintrustdata/braintrust-kotlin/commit/ad903a2ba07c510348634c003f70e5a84b2edc6e))
* update @stainless-api/prism-cli to v5.15.0 ([08cdbb1](https://github.com/braintrustdata/braintrust-kotlin/commit/08cdbb14f4fde152a4c53ab41820426fef89c0ef))


### Documentation

* add `build` method comments ([#125](https://github.com/braintrustdata/braintrust-kotlin/issues/125)) ([54c75b9](https://github.com/braintrustdata/braintrust-kotlin/commit/54c75b923c8bb9a048d26fd31872444b0bea081a))
* add comments for page methods ([71968b4](https://github.com/braintrustdata/braintrust-kotlin/commit/71968b4109ba33d824a9dbdf7567aa90b7b0ff6a))
* add comments to `JsonField` classes ([#148](https://github.com/braintrustdata/braintrust-kotlin/issues/148)) ([a53cd38](https://github.com/braintrustdata/braintrust-kotlin/commit/a53cd383e1f5b66a7c98fdab5c045eefc667c82a))
* add more phantom reachability docs ([#94](https://github.com/braintrustdata/braintrust-kotlin/issues/94)) ([15a955a](https://github.com/braintrustdata/braintrust-kotlin/commit/15a955a5a502aa4c0ec830997b118c5d8a485bd0))
* add raw response readme documentation ([#100](https://github.com/braintrustdata/braintrust-kotlin/issues/100)) ([4c488b8](https://github.com/braintrustdata/braintrust-kotlin/commit/4c488b803b1f69cb409eb6c1214d6723997381ce))
* **client:** update jackson compat error message ([586f861](https://github.com/braintrustdata/braintrust-kotlin/commit/586f86117cf81cffec6f64e11694057cad325ae2))
* deduplicate and refine comments ([#122](https://github.com/braintrustdata/braintrust-kotlin/issues/122)) ([a47e6a6](https://github.com/braintrustdata/braintrust-kotlin/commit/a47e6a6e57c7250986794b6808ec46500a49c370))
* document `JsonValue` construction in readme ([#109](https://github.com/braintrustdata/braintrust-kotlin/issues/109)) ([11b3017](https://github.com/braintrustdata/braintrust-kotlin/commit/11b3017071384e9e36281492721fdf88b7027687))
* document how to forcibly omit required field ([d1d2b4e](https://github.com/braintrustdata/braintrust-kotlin/commit/d1d2b4e30df7530fbaf0fd8abdc67a17ea08314d))
* explain http client customization ([d19552a](https://github.com/braintrustdata/braintrust-kotlin/commit/d19552a231d1dde19da4a7f25c8e0b763df67cab))
* explain jackson compat in readme ([0855121](https://github.com/braintrustdata/braintrust-kotlin/commit/085512167b07d63932bcddb8266a762c416d58c7))
* fix missing readme comment ([32b005b](https://github.com/braintrustdata/braintrust-kotlin/commit/32b005bce1c7cba24af587f1ec39e26cf2aa9e89))
* minor readme tweak ([#136](https://github.com/braintrustdata/braintrust-kotlin/issues/136)) ([d802340](https://github.com/braintrustdata/braintrust-kotlin/commit/d80234046327fae20d37c79bc97a62b3fc91d751))
* more code comments ([869771b](https://github.com/braintrustdata/braintrust-kotlin/commit/869771b2a3cc93d84baf4c25590f5c70ef994733))
* note required fields in `builder` javadoc ([#101](https://github.com/braintrustdata/braintrust-kotlin/issues/101)) ([fac37c4](https://github.com/braintrustdata/braintrust-kotlin/commit/fac37c454be319939a43b52f89fe259768214b11))
* refine comments on multipart params ([#133](https://github.com/braintrustdata/braintrust-kotlin/issues/133)) ([1c4b313](https://github.com/braintrustdata/braintrust-kotlin/commit/1c4b313004a2402143fc10e8f2798339ae2ea22f))
* remove `$` for better copy-pasteabality ([9fbdb0d](https://github.com/braintrustdata/braintrust-kotlin/commit/9fbdb0dd607df02472c5b515b4dbb8183ace8661))
* revise readme docs about nested params ([#108](https://github.com/braintrustdata/braintrust-kotlin/issues/108)) ([6c4a081](https://github.com/braintrustdata/braintrust-kotlin/commit/6c4a081468757ffa6e2e6039b90772691e19ef3a))
* swap examples used in readme ([#149](https://github.com/braintrustdata/braintrust-kotlin/issues/149)) ([d1d2b4e](https://github.com/braintrustdata/braintrust-kotlin/commit/d1d2b4e30df7530fbaf0fd8abdc67a17ea08314d))
* update documentation links to be more uniform ([8d54da2](https://github.com/braintrustdata/braintrust-kotlin/commit/8d54da2dd7d3489cef999e28dabb8fd1437bca56))
* update readme exception docs ([#135](https://github.com/braintrustdata/braintrust-kotlin/issues/135)) ([cedf2ce](https://github.com/braintrustdata/braintrust-kotlin/commit/cedf2ce2a6a26f6c0ef5b43771e42f8ef214bdd1))


### Refactors

* **client:** deduplicate page response classes ([71968b4](https://github.com/braintrustdata/braintrust-kotlin/commit/71968b4109ba33d824a9dbdf7567aa90b7b0ff6a))
* **client:** migrate pages to builder pattern ([2113261](https://github.com/braintrustdata/braintrust-kotlin/commit/21132614bb49582679dfddbfa7c631bd80b44d00))
* **internal:** minor `ClientOptionsTest` change ([151c8eb](https://github.com/braintrustdata/braintrust-kotlin/commit/151c8eba64ad1bc5e4232bb9afad4b36655cb197))

## 0.3.0 (2024-10-01)

Full Changelog: [v0.2.0...v0.3.0](https://github.com/braintrustdata/braintrust-kotlin/compare/v0.2.0...v0.3.0)

### Features

* **api:** manual updates ([#47](https://github.com/braintrustdata/braintrust-kotlin/issues/47)) ([36a795d](https://github.com/braintrustdata/braintrust-kotlin/commit/36a795d743eecb43dc011e4251ae109b62e5eca1))

## 0.2.0 (2024-10-01)

Full Changelog: [v0.1.0...v0.2.0](https://github.com/braintrustdata/braintrust-kotlin/compare/v0.1.0...v0.2.0)

### Features

* add model ProjectScoreCategory ([#24](https://github.com/braintrustdata/braintrust-kotlin/issues/24)) ([ddb59b3](https://github.com/braintrustdata/braintrust-kotlin/commit/ddb59b37ec22373a6a1ed98274cd7f936afe2dbe))
* **api:** deduplication ([#42](https://github.com/braintrustdata/braintrust-kotlin/issues/42)) ([d648f93](https://github.com/braintrustdata/braintrust-kotlin/commit/d648f9346d32fad58f4fdb582c7e9ae7f111d34c))
* **api:** manual updates ([#25](https://github.com/braintrustdata/braintrust-kotlin/issues/25)) ([7035278](https://github.com/braintrustdata/braintrust-kotlin/commit/70352785fe2c3317cb74dedc9a7c929cefbd3b03))
* **api:** manual updates ([#26](https://github.com/braintrustdata/braintrust-kotlin/issues/26)) ([67b706c](https://github.com/braintrustdata/braintrust-kotlin/commit/67b706cb5bce82258511ccf3d0e3434b2454d138))
* **api:** manual updates ([#27](https://github.com/braintrustdata/braintrust-kotlin/issues/27)) ([766174b](https://github.com/braintrustdata/braintrust-kotlin/commit/766174b45c7d76228f22ef8d38ee3bf3711863ee))
* **api:** manual updates ([#43](https://github.com/braintrustdata/braintrust-kotlin/issues/43)) ([dcbb1e3](https://github.com/braintrustdata/braintrust-kotlin/commit/dcbb1e3a979cdbea44a7eb9f457a8d0e34ee5dba))
* **api:** manual updates ([#44](https://github.com/braintrustdata/braintrust-kotlin/issues/44)) ([4b94076](https://github.com/braintrustdata/braintrust-kotlin/commit/4b94076346cc334ad1d477c49fa22ce78bd86062))
* **api:** manual updates ([#45](https://github.com/braintrustdata/braintrust-kotlin/issues/45)) ([f2ce39d](https://github.com/braintrustdata/braintrust-kotlin/commit/f2ce39d764647b160b880b64d3c82178124d4735))
* **api:** update via SDK Studio ([#10](https://github.com/braintrustdata/braintrust-kotlin/issues/10)) ([697e364](https://github.com/braintrustdata/braintrust-kotlin/commit/697e364b4256303a006bb307de7063a211e43484))
* **api:** update via SDK Studio ([#11](https://github.com/braintrustdata/braintrust-kotlin/issues/11)) ([775294e](https://github.com/braintrustdata/braintrust-kotlin/commit/775294ec443c9dae0e7c79d8ac7bc045c7bb4a7a))
* **api:** update via SDK Studio ([#12](https://github.com/braintrustdata/braintrust-kotlin/issues/12)) ([04917f0](https://github.com/braintrustdata/braintrust-kotlin/commit/04917f0afdcbf1618dc754a53e2b11858f5026e2))
* **api:** update via SDK Studio ([#13](https://github.com/braintrustdata/braintrust-kotlin/issues/13)) ([d19db86](https://github.com/braintrustdata/braintrust-kotlin/commit/d19db861d757e6e1fbade8d745172cff7984fa72))
* **api:** update via SDK Studio ([#14](https://github.com/braintrustdata/braintrust-kotlin/issues/14)) ([f0fab83](https://github.com/braintrustdata/braintrust-kotlin/commit/f0fab83bf2af7552496efdae8896d2b728a582ce))
* **api:** update via SDK Studio ([#15](https://github.com/braintrustdata/braintrust-kotlin/issues/15)) ([32af79d](https://github.com/braintrustdata/braintrust-kotlin/commit/32af79d8de44e5ba7c06c6c30d45258c14b89880))
* **api:** update via SDK Studio ([#16](https://github.com/braintrustdata/braintrust-kotlin/issues/16)) ([48584bc](https://github.com/braintrustdata/braintrust-kotlin/commit/48584bc064e968de1ef429d857d143c3eb7bf0b7))
* **api:** update via SDK Studio ([#17](https://github.com/braintrustdata/braintrust-kotlin/issues/17)) ([e38a7f6](https://github.com/braintrustdata/braintrust-kotlin/commit/e38a7f6da17ef3087336c66258421eaa56eb6b60))
* **api:** update via SDK Studio ([#18](https://github.com/braintrustdata/braintrust-kotlin/issues/18)) ([b802209](https://github.com/braintrustdata/braintrust-kotlin/commit/b802209c1fd970d1f05bf5d91d4bc214e52668fd))
* **api:** update via SDK Studio ([#19](https://github.com/braintrustdata/braintrust-kotlin/issues/19)) ([54737b4](https://github.com/braintrustdata/braintrust-kotlin/commit/54737b4fa5891b0449f731b638f7e9f9fce14538))
* **api:** update via SDK Studio ([#20](https://github.com/braintrustdata/braintrust-kotlin/issues/20)) ([4920cd4](https://github.com/braintrustdata/braintrust-kotlin/commit/4920cd4b879e32ddb0e25229361056e4dd500dd1))
* **api:** update via SDK Studio ([#21](https://github.com/braintrustdata/braintrust-kotlin/issues/21)) ([ceb91b1](https://github.com/braintrustdata/braintrust-kotlin/commit/ceb91b199deac04acb431c62bd81090c8d67f708))
* **api:** update via SDK Studio ([#23](https://github.com/braintrustdata/braintrust-kotlin/issues/23)) ([69f18a3](https://github.com/braintrustdata/braintrust-kotlin/commit/69f18a3b5dab65cd982b54acda0ad42d92d4fe4d))
* **api:** update via SDK Studio ([#29](https://github.com/braintrustdata/braintrust-kotlin/issues/29)) ([b5ae960](https://github.com/braintrustdata/braintrust-kotlin/commit/b5ae960496c494c3022f942695572a4ebc9ecee4))
* **api:** update via SDK Studio ([#31](https://github.com/braintrustdata/braintrust-kotlin/issues/31)) ([29f340b](https://github.com/braintrustdata/braintrust-kotlin/commit/29f340bbb3d1b30ab9310909a089a97032f823fb))
* **api:** update via SDK Studio ([#32](https://github.com/braintrustdata/braintrust-kotlin/issues/32)) ([08636e2](https://github.com/braintrustdata/braintrust-kotlin/commit/08636e2d06b460fcaab3d79e2851d8095eb54f02))
* **api:** update via SDK Studio ([#33](https://github.com/braintrustdata/braintrust-kotlin/issues/33)) ([9592d2f](https://github.com/braintrustdata/braintrust-kotlin/commit/9592d2fbb958f3250f4e64ffc1e6678c9ba298f5))
* **api:** update via SDK Studio ([#34](https://github.com/braintrustdata/braintrust-kotlin/issues/34)) ([d1ebef7](https://github.com/braintrustdata/braintrust-kotlin/commit/d1ebef71e1e9f15ca5fa964e63e87ef4947dbd1e))
* **api:** update via SDK Studio ([#35](https://github.com/braintrustdata/braintrust-kotlin/issues/35)) ([a12b251](https://github.com/braintrustdata/braintrust-kotlin/commit/a12b251e4728b166f5c3ec0371e7cc3eed7ad677))
* **api:** update via SDK Studio ([#36](https://github.com/braintrustdata/braintrust-kotlin/issues/36)) ([c270d7b](https://github.com/braintrustdata/braintrust-kotlin/commit/c270d7bf2d723b915ed23fb15c54a3f14d85f802))
* **api:** update via SDK Studio ([#37](https://github.com/braintrustdata/braintrust-kotlin/issues/37)) ([36ccf26](https://github.com/braintrustdata/braintrust-kotlin/commit/36ccf2687dd25feb037ca4fda821c1df473d7a5d))
* **api:** update via SDK Studio ([#38](https://github.com/braintrustdata/braintrust-kotlin/issues/38)) ([47f5f48](https://github.com/braintrustdata/braintrust-kotlin/commit/47f5f4860ee6ad6ea620ed2c34ebe020a53c5d26))
* **api:** update via SDK Studio ([#39](https://github.com/braintrustdata/braintrust-kotlin/issues/39)) ([24b8201](https://github.com/braintrustdata/braintrust-kotlin/commit/24b8201a5bbb3bd91345f3cc4dcece74124008af))
* **api:** update via SDK Studio ([#4](https://github.com/braintrustdata/braintrust-kotlin/issues/4)) ([cc185e8](https://github.com/braintrustdata/braintrust-kotlin/commit/cc185e84faf729a8164705ee6c4065b1ccf1e9ad))
* **api:** update via SDK Studio ([#6](https://github.com/braintrustdata/braintrust-kotlin/issues/6)) ([23923fc](https://github.com/braintrustdata/braintrust-kotlin/commit/23923fc22a197bfddacb406727da8b9272bcafa1))
* **api:** update via SDK Studio ([#7](https://github.com/braintrustdata/braintrust-kotlin/issues/7)) ([11b1ce9](https://github.com/braintrustdata/braintrust-kotlin/commit/11b1ce9e9a94c2ef25fbeff18c6945cdaf4a7348))
* **api:** update via SDK Studio ([#8](https://github.com/braintrustdata/braintrust-kotlin/issues/8)) ([f6f613b](https://github.com/braintrustdata/braintrust-kotlin/commit/f6f613b24fb3ca87d3bceb4171e1170674e69cde))
* **api:** update via SDK Studio ([#9](https://github.com/braintrustdata/braintrust-kotlin/issues/9)) ([d89d0ae](https://github.com/braintrustdata/braintrust-kotlin/commit/d89d0aeed782b76773635519c11cba5247c98608))


### Bug Fixes

* **api:** fix go build ([#41](https://github.com/braintrustdata/braintrust-kotlin/issues/41)) ([6dc4ee2](https://github.com/braintrustdata/braintrust-kotlin/commit/6dc4ee2b7c93ac7a178352eeafbfd12ca92606e8))
* **internal:** fix imports and tests ([73f38b5](https://github.com/braintrustdata/braintrust-kotlin/commit/73f38b5c2796df2a4208776edeefdc3411fa5398))


### Chores

* **ci:** bump prism mock server version ([#28](https://github.com/braintrustdata/braintrust-kotlin/issues/28)) ([c72696a](https://github.com/braintrustdata/braintrust-kotlin/commit/c72696ab62fed81e33cfbfe03bfd91dd5ab326ba))
* **internal:** codegen related update ([#22](https://github.com/braintrustdata/braintrust-kotlin/issues/22)) ([e4c8264](https://github.com/braintrustdata/braintrust-kotlin/commit/e4c8264b8f145372bb53aa67e8840563310d7985))
* **internal:** codegen related update ([#30](https://github.com/braintrustdata/braintrust-kotlin/issues/30)) ([a7917d3](https://github.com/braintrustdata/braintrust-kotlin/commit/a7917d3fc94536e876e6cb7b2c137be1999fcc25))
* **internal:** codegen related update ([#40](https://github.com/braintrustdata/braintrust-kotlin/issues/40)) ([f2daadb](https://github.com/braintrustdata/braintrust-kotlin/commit/f2daadb4c19867c58b263574facc10d8da302c5e))

## 0.1.0 (2024-02-04)

Full Changelog: [v0.0.1...v0.1.0](https://github.com/braintrustdata/braintrust-kotlin/compare/v0.0.1...v0.1.0)

### Features

* Add initial Stainless SDK ([9654fb8](https://github.com/braintrustdata/braintrust-kotlin/commit/9654fb8513f40b898092b773f96e54e996009b09))
* create default branch ([160596a](https://github.com/braintrustdata/braintrust-kotlin/commit/160596a7c8fd24ffcdfc07edafa4437313c9a850))
* OpenAPI spec update ([#1](https://github.com/braintrustdata/braintrust-kotlin/issues/1)) ([536a660](https://github.com/braintrustdata/braintrust-kotlin/commit/536a66092ef8ed6850c6fd43f167cf9baf35a14a))
* OpenAPI spec update ([#3](https://github.com/braintrustdata/braintrust-kotlin/issues/3)) ([bb3cc00](https://github.com/braintrustdata/braintrust-kotlin/commit/bb3cc00b420f1a8cc9d269a62e4ccebdbaf1a69d))
