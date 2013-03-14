fop-odt-integration
===================

This is a simple attempt at generating ODT (OpenDocument Text) documents from Formatting Objects files using Apache FOP
and the ODF Toolkit's Simple API. Only very basic functionality is currently supported, and you probably don't want to
use this unless you're rather ambitious and ready to be surprised a lot.

I needed some basic FOP-to-ODF functionality for a project I've been working on, and I found that a lot of the ad-hoc
code could be generalized to support some of the more common use cases for such a library. That said, I feign no attempt
at standards compliance, nor any deep knowledge of FO or ODF standards.

*Please note that this library is NOT associated with the Apache FOP or Apache ODF Toolkit projects in any fashion.*

License
-------

This work is licensed under the [Apache License, Version 2.0](http://www.apache.org/licenses/LICENSE-2.0). That said,
I'd really appreciate it if you'd release any of your own improvements or additions to the code back into this project
as well.

Installation Instructions
-------------------------

This is a Maven project, so everything you need should be available by checking out the source and running the
appropriate Maven commands. Since this is intended to be used programatically, there's really not any executable here,
but you can see some generated output if you run the unit tests via `mvn test`.

If you're using it in your own project, the main thing you need to do is register the ODTEventHandlerMaker:

    fopFactory.getRendererFactory().addFOEventHandlerMaker(new ODTEventHandlerMaker());

To have FOP actually use it, you just need to specify the MIME type for the ODT files when getting a new Fop instance:

    Fop fop = fopFactory.newFop(ODTEventHandlerMaker.MIME_TYPE, outputStream);

Documentation
-------------

Aside from this README, the most useful documentation is probably the code itself. I've tried to be rather diligent in
using Javadoc comments in my code, so you can always run `mvn javadoc:javadoc` and produce your own set of docs.

If you're new and have more general questions on how to use FOP or the ODF framework, I'd refer you to either the
[Apache FOP](http://xmlgraphics.apache.org/fop/) or [Apache ODF Toolkit](http://incubator.apache.org/odftoolkit/)
sites. *They didn't write this library, however, so don't go asking them for help about it!*

Contributions
-------------

So far this has just been a personal effort, though I couldn't have done this in a week if lots of people hadn't spent
months and years writing and documenting the frameworks and libraries I've leveraged. As is, it currently meets all my
needs, but I'd like to think that this could prove useful to others as a starting point or discussion point for
supporting ODT output from FOP at some point. If anyone else out there finds this useful or is interested in working on
the code, I'd love to hear from you.

Implementation
--------------

When FOP is requested to generate an ODT output file, this library maps the calls from FOP to the appropriate calls to
the ODF Toolkit's Simple API or ODFDOM API to generate the document. In more detail, here's what happens:

1. The ODTEventHandlerMaker is registered with Apache FOP with the corresponding MIME type for OpenDocument Text.
2. When requested by FOP, the ODTEventHandlerMaker returns a configured ODTHandler instance.
3. The ODTHandler is called in a SAX-like fashion as FOP traverses the FO content.
4. The ODTHandler maintains state internally using a chain of ODTHandlerState instances to determine what to do.
5. The ODTHandler and the associated ODTHandlerStates use the ODF DOM and Simple APIs to generate the output document.
6. When the FO has been processed, the ODTHandler writes out the generated document to the provided OutputStream.

Status
------

The current implementation implements a subset of FOP functionality. Currently the following .fo files from the Apache
FOP project are being used as a reference for test cases:

- `footnotes/simple.fo`
- `pagination/basic2.fo`
- `simple/alignment.fo`
- `simple/border.fo`
- `simple/character.fo`
- `simple/fonts.fo`
- `simple/leader.fo`
- `simple/list.fo`
- `simple/normal.fo`
- `simple/simple.fo`
- `simple/table.fo`
- `simple/textdeko.fo`
- `tables/headfoot.fo`

### Implemented features

- Block elements
- Character elements
- Fonts
- Inline elements
- Lists (including nested lists)
- Page breaks (before and after block elements)
- Page numbers
- Tables (with the exceptions noted below)

### Partially-implemented features

- Footers (minimal support based on xsl-region-after mapping to the ODT footer)
- Headers (minimal support based on xsl-region-before mapping to the ODT header)
- Page numbers
- Spacing
- Text line styles (with some exceptions, such as the `overline` style)
- Table borders (there are issues with interactions between table and cell borders when mapping to ODF content)

### Unimplemented features

- Footnotes
- Flow
- Images
- Instream foreign objects
- Keep-with/keep-together (and related features)
- Links
- List labels
- List margins
- Page layouts
- Positioning (particularly absolute positioning)
- Table footers
- Table positioning and sizing
- Table headers

- (Also anything else not explicitly mentioned above)
