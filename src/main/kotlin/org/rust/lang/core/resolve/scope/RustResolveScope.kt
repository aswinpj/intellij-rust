package org.rust.lang.core.resolve.scope

import org.rust.lang.core.psi.RustCompositeElement
import org.rust.lang.core.psi.RustDeclaringElement
import org.rust.lang.core.psi.RustNamedElement
import org.rust.lang.core.resolve.RustResolveEngine

public interface RustResolveScope : RustCompositeElement {
    val declarations: Collection<RustDeclaringElement>
}

val RustResolveScope.boundElements: Collection<RustNamedElement>
    get() = declarations.flatMap { it.boundElements }

