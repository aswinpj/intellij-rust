package org.rust.ide.colorscheme

import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import com.intellij.openapi.util.io.StreamUtil
import org.rust.ide.highlight.syntax.RustHighlighter
import org.rust.ide.icons.RustIcons
import com.intellij.openapi.options.colors.AttributesDescriptor as d

public class RustColorSettingsPage : ColorSettingsPage {
    private val ATTRS = arrayOf(
        d("Identifier", RustColors.IDENTIFIER),
        d("Lifetime", RustColors.LIFETIME),
        d("Char", RustColors.CHAR),
        d("String", RustColors.STRING),
        d("Number", RustColors.NUMBER),
        d("Keyword", RustColors.KEYWORD),
        d("Block comment", RustColors.BLOCK_COMMENT),
        d("Line comment", RustColors.EOL_COMMENT),
        d("Doc comment", RustColors.DOC_COMMENT),
        d("Parenthesis", RustColors.PARENTHESIS),
        d("Brackets", RustColors.BRACKETS),
        d("Braces", RustColors.BRACES),
        d("Operator sign", RustColors.OPERATORS),
        d("Semicolon", RustColors.SEMICOLON),
        d("Dot", RustColors.DOT),
        d("Comma", RustColors.COMMA),
        d("Attribute", RustColors.ATTRIBUTE),
        d("Macro", RustColors.MACRO),
        d("Type Parameter", RustColors.TYPE_PARAMETER),
        d("Mutable binding", RustColors.MUT_BINDING),
        d("Valid escape sequence", RustColors.VALID_STRING_ESCAPE),
        d("Invalid escape sequence", RustColors.INVALID_STRING_ESCAPE)
    )
    // This tags should be kept in sync with RustAnnotator highlighting logic
    private val ANNOTATOR_TAGS = mapOf(
        "attribute" to RustColors.ATTRIBUTE,
        "macro" to RustColors.MACRO,
        "type-parameter" to RustColors.TYPE_PARAMETER,
        "mut-binding" to RustColors.MUT_BINDING
    )
    private val DEMO_TEXT by lazy {
        val stream = javaClass.classLoader.getResourceAsStream("org/rust/ide/colorscheme/highlighterDemoText.rs")
        // We need to convert line separators here, because IntelliJ always expects \n,
        // while on Windows the resource file will be read with \r\n as line separator.
        StreamUtil.convertSeparators(StreamUtil.readText(stream, "UTF-8"))
    }

    override fun getDisplayName() = "Rust"
    override fun getIcon() = RustIcons.RUST
    override fun getAttributeDescriptors() = ATTRS
    override fun getColorDescriptors() = ColorDescriptor.EMPTY_ARRAY
    override fun getHighlighter() = RustHighlighter()
    override fun getAdditionalHighlightingTagToDescriptorMap() = ANNOTATOR_TAGS
    override fun getDemoText() = DEMO_TEXT
}
